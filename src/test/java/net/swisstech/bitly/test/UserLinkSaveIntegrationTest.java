/*
 * Copyright (c) Patrick Huber (gmail: stackmagic)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.swisstech.bitly.test;

import static net.swisstech.bitly.test.util.TestUtil.printAndVerify;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserLinkEditResponse;
import net.swisstech.bitly.model.v3.UserLinkSaveResponse;

import org.joda.time.DateTime;
import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_user_link_save">/v3/user/link_save</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkSaveIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callUserLinkSaveExistingLink() {
		// must have a unique link and so we add milliseconds
		Response<UserLinkSaveResponse> resp = getClient().userLinkSave() //
				.setLongUrl("https://www.example.com/bitly-api-client-test") //
				.setTitle("example user link save (existing)") //
				.setNote("testing link save (existing)") //
				.setPrivate(true) //
				.setUserTs(DateTime.now()) //
				.call();

		printAndVerify(resp, UserLinkSaveResponse.class, 304, "LINK_ALREADY_EXISTS");

		assertEquals(resp.data.link_save.aggregate_link, "http://bit.ly/MtVsf2");
		assertEquals(resp.data.link_save.link, "http://bit.ly/MtVsf1");
		assertEquals(resp.data.link_save.long_url, "https://www.example.com/bitly-api-client-test");
		assertEquals(resp.data.link_save.new_link, 0);
	}

	@Test
	public void callUserLinkSaveNewLink() {
		String longUrl = "https://www.example.com/bitly-api-client-test/" + System.currentTimeMillis();
		Response<UserLinkSaveResponse> resp = getClient().userLinkSave() //
				.setLongUrl(longUrl) //
				.setTitle("example user link save (new)") //
				.setNote("testing link save (new)") //
				.setPrivate(true) //
				.setUserTs(DateTime.now()) //
				.call();

		printAndVerify(resp, UserLinkSaveResponse.class);

		assertNotNull(resp.data.link_save.link);
		assertNotNull(resp.data.link_save.aggregate_link);
		assertEquals(resp.data.link_save.long_url, longUrl);
		assertEquals(resp.data.link_save.new_link, 1);

		// can't have this showing up in my history so archive it
		Response<UserLinkEditResponse> edit = getClient().userLinkEdit() //
				.setLink(resp.data.link_save.link) //
				.setArchived(true) //
				.call();

		printAndVerify(edit, UserLinkEditResponse.class);

		assertEquals(edit.data.link_edit.link, resp.data.link_save.link);
	}
}

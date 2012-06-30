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
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserLinkEditResponse;

import org.joda.time.DateTime;
import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_user_link_edit">/v3/user/link_edit</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkEditIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callUserLinkEdit() {
		// test link to https://www.example.com/bitly-api-client-test
		Response<UserLinkEditResponse> resp = getClient().userLinkEdit() //
				.setLink("http://bit.ly/MtVsf1") //
				.setNote("Note: " + System.currentTimeMillis()) //
				.setUserTs(DateTime.now()) //
				.call();

		printAndVerify(resp, UserLinkEditResponse.class);

		assertEquals(resp.data.link_edit.link, "http://bit.ly/MtVsf1");
	}
}

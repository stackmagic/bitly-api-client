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
import net.swisstech.bitly.model.v3.UserLinkLookupResponse;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_user_link_lookup">/v3/user/link_lookup</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkLookupIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callUserLinkLookup() {
		Response<UserLinkLookupResponse> resp = getClient().userLinkLookup() //
				.addUrl("https://www.example.com/bitly-api-client-test") //
				.call();

		printAndVerify(resp, UserLinkLookupResponse.class);

		assertEquals(resp.data.link_lookup.size(), 1);
		assertEquals(resp.data.link_lookup.get(0).aggregate_link, "http://bit.ly/MtVsf2");
		assertEquals(resp.data.link_lookup.get(0).link, "http://bit.ly/MtVsf1");
		assertEquals(resp.data.link_lookup.get(0).url, "https://www.example.com/bitly-api-client-test");
	}
}

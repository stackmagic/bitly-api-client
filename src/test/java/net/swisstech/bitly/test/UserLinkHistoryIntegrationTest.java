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
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserLinkHistoryResponse;
import net.swisstech.bitly.model.v3.UserLinkHistoryResponse.Share;
import net.swisstech.bitly.model.v3.UserLinkHistoryResponse.UserLinkHistory;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_info.html#v3_user_link_history">/v3/user/link_history</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkHistoryIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callUserLinkHistoryGeneral() {
		Response<UserLinkHistoryResponse> resp = getClient().userLinkHistory() //
				.call();

		printAndVerify(resp, UserLinkHistoryResponse.class);

		assertTrue(resp.data.link_history.size() > 0);
		for (UserLinkHistory ulh : resp.data.link_history) {
			assertNotNull(ulh.link);
			if (ulh.shares != null) {
				for (Share s : ulh.shares) {
					assertNotNull(s.share_id);
				}
			}
		}
	}

	@Test
	public void callUserLinkHistoryPrivateOn() {
		Response<UserLinkHistoryResponse> resp = getClient().userLinkHistory() //
				.setPrivate("on") //
				.call();

		printAndVerify(resp, UserLinkHistoryResponse.class);

		assertTrue(resp.data.link_history.size() > 0);
		for (UserLinkHistory ulh : resp.data.link_history) {
			assertTrue(ulh.privat);
		}
	}

	@Test
	public void callUserLinkHistoryPrivateOff() {
		Response<UserLinkHistoryResponse> resp = getClient().userLinkHistory() //
				.setPrivate("off") //
				.call();

		printAndVerify(resp, UserLinkHistoryResponse.class);

		assertTrue(resp.data.link_history.size() > 0);
		for (UserLinkHistory ulh : resp.data.link_history) {
			assertFalse(ulh.privat);
		}
	}

	@Test
	public void callUserLinkHistoryArchivedOn() {
		Response<UserLinkHistoryResponse> resp = getClient().userLinkHistory() //
				.setArchived("on") //
				.call();

		printAndVerify(resp, UserLinkHistoryResponse.class);

		assertTrue(resp.data.link_history.size() > 0);
		for (UserLinkHistory ulh : resp.data.link_history) {
			assertTrue(ulh.archived);
		}
	}

	@Test
	public void callUserLinkHistoryArchivedOff() {
		Response<UserLinkHistoryResponse> resp = getClient().userLinkHistory() //
				.setArchived("off") //
				.call();

		printAndVerify(resp, UserLinkHistoryResponse.class);

		assertTrue(resp.data.link_history.size() > 0);
		for (UserLinkHistory ulh : resp.data.link_history) {
			assertFalse(ulh.archived);
		}
	}

	@Test
	public void callUserLinkHistoryForSingleLink() {
		Response<UserLinkHistoryResponse> resp = getClient().userLinkHistory() //
				.setLink("http://bit.ly/LlpM8d") //
				.call();

		printAndVerify(resp, UserLinkHistoryResponse.class);

		assertEquals(resp.data.link_history.size(), 1);
	}

	@Test
	public void callUserLinkHistoryForAnotherUser() {
		Response<UserLinkHistoryResponse> resp = getClient().userLinkHistory() //
				.setUser("bufferapp") //
				.call();

		printAndVerify(resp, UserLinkHistoryResponse.class);

		assertTrue(resp.data.link_history.size() > 0);
	}
}

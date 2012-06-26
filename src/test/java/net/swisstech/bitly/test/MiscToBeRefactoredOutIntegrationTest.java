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
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.LinkReferringDomains;
import net.swisstech.bitly.model.v3.LinkShares;
import net.swisstech.bitly.model.v3.UserClicksExpanded;
import net.swisstech.bitly.model.v3.UserClicksRolledUp;
import net.swisstech.bitly.model.v3.UserCountriesExpanded;
import net.swisstech.bitly.model.v3.UserInfo;
import net.swisstech.bitly.model.v3.UserLinkHistory;
import net.swisstech.bitly.model.v3.UserNetworkHistory;
import net.swisstech.bitly.model.v3.UserPopularLinksExpanded;
import net.swisstech.bitly.model.v3.UserReferrersExpanded;
import net.swisstech.bitly.model.v3.UserReferringDomainsExpanded;
import net.swisstech.bitly.model.v3.UserShareCountsByShareTypeExpanded;
import net.swisstech.bitly.model.v3.UserShareCountsExpanded;
import net.swisstech.bitly.model.v3.UserShortenCounts;
import net.swisstech.bitly.model.v3.UserTrackingDomainList;

import org.testng.annotations.Test;

public class MiscToBeRefactoredOutIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callLinkReferringDomains() {
		Response<LinkReferringDomains> resp = getClient().linkReferringDomains() //
				.setLink("http://bit.ly/LfXpbF") //
				.setUnit("hour") //
				.setUnits(-1) //
				.setTimezone(0) //
				.setLimit(1000) //
				.call();

		printAndVerify(resp, LinkReferringDomains.class);

		for (LinkReferringDomains.ReferringDomain rd : resp.data.referring_domains) {
			assertTrue(rd.clicks > 0);
			assertNotNull(rd.domain);
			if ("direct".equals(rd.domain)) {
				assertNull(rd.url);
			}
			else {
				assertNotNull(rd.url);
			}
		}
	}

	@Test
	public void callLinkShares() {
		Response<LinkShares> resp = getClient().linkShares() //
				.setLink("http://bit.ly/cJ8Hst") //
				.setUnit("month") //
				.setUnits(-1) //
				.setTimezone(0) //
				.setLimit(1000) //
				.call();

		printAndVerify(resp, LinkShares.class);

		// the api doesn't seem to return any shares and total_shares data
		assertEquals(resp.data.shares.size(), 0);
		assertEquals(resp.data.total_shares, 0);
		assertEquals(resp.data.unit, "month");
		assertEquals(resp.data.units, -1);
		assertEquals(resp.data.tz_offset, 0);
	}

	@Test
	public void callUserInfoForAccessTokenUser() {
		Response<UserInfo> resp = getClient().userInfo() //
				.call();

		printAndVerify(resp, UserInfo.class);

		// you need to change this to your own user name
		assertEquals(resp.data.login, "stackmagic");
	}

	@Test
	public void callUserInfoForAnotherLogin() {
		Response<UserInfo> resp = getClient().userInfo() //
				.setLogin("bufferapp") //
				.call();

		printAndVerify(resp, UserInfo.class);

		assertEquals(resp.data.login, "bufferapp");
	}

	@Test
	public void callUserLinkHistoryGeneral() {
		Response<UserLinkHistory> resp = getClient().userLinkHistory() //
				.call();

		printAndVerify(resp, UserLinkHistory.class);
	}

	@Test
	public void callUserLinkHistoryForSingleLink() {
		Response<UserLinkHistory> resp = getClient().userLinkHistory() //
				.setLink("http://bit.ly/LlpM8d") //
				.call();

		printAndVerify(resp, UserLinkHistory.class);
	}

	@Test
	public void callUserLinkHistoryForAnotherUser() {
		Response<UserLinkHistory> resp = getClient().userLinkHistory() //
				.setUser("bufferapp") //
				.call();

		printAndVerify(resp, UserLinkHistory.class);
	}

	@Test
	public void callUserNetworkHistory() {
		Response<UserNetworkHistory> resp = getClient().userNetworkHistory() //
				.call();

		printAndVerify(resp, UserNetworkHistory.class);
	}

	@Test
	public void callUserTrackingDomainList() {
		Response<UserTrackingDomainList> resp = getClient().userTrackingDomainList() //
				.call();

		printAndVerify(resp, UserTrackingDomainList.class);
	}

	@Test
	public void callUserClicksExpanded() {
		Response<UserClicksExpanded> resp = getClient().userClicksExpanded() //
				.setUnit("day") //
				.setUnits(500) //
				.call();

		printAndVerify(resp, UserClicksExpanded.class);
	}

	@Test
	public void callUserClicksRolledUp() {
		Response<UserClicksRolledUp> resp = getClient().userClicksRolledUp() //
				.setUnit("day") //
				.setUnits(500) //
				.call();

		printAndVerify(resp, UserClicksRolledUp.class);
	}

	@Test
	public void callUserCountriesExpanded() {
		Response<UserCountriesExpanded> resp = getClient().userCountriesExpanded() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserCountriesExpanded.class);
	}

	@Test
	public void callUserPopularLinksExpanded() {
		Response<UserPopularLinksExpanded> resp = getClient().userPopularLinksExpanded() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserPopularLinksExpanded.class);
	}

	@Test
	public void callUserReferrersExpanded() {
		Response<UserReferrersExpanded> resp = getClient().userReferersExpanded() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserReferrersExpanded.class);
	}

	// this returns a 404
	@Test(enabled = false)
	public void callUserReferringDomainsExpanded() {
		Response<UserReferringDomainsExpanded> resp = getClient().userReferringDomainsExpanded() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserReferringDomainsExpanded.class);
	}

	@Test
	public void callUserShareCountsExpanded() {
		Response<UserShareCountsExpanded> resp = getClient().userShareCountsExpanded() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserShareCountsExpanded.class);
	}

	@Test
	public void callUserShareCountsByShareTypeExpanded() {
		Response<UserShareCountsByShareTypeExpanded> resp = getClient().userShareCountyByShareTypeExpanded() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserShareCountsByShareTypeExpanded.class);
	}

	@Test
	public void callUserShortenCounts() {
		Response<UserShortenCounts> resp = getClient().userShortenCounts() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserShortenCounts.class);
	}
}

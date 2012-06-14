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

import java.io.IOException;
import java.util.Arrays;

import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.Expand;
import net.swisstech.bitly.model.v3.Info;
import net.swisstech.bitly.model.v3.LinkClicksExpanded;
import net.swisstech.bitly.model.v3.LinkClicksRolledUp;
import net.swisstech.bitly.model.v3.LinkCountriesExpanded;
import net.swisstech.bitly.model.v3.LinkCountriesRolledUp;
import net.swisstech.bitly.model.v3.LinkEncodersCount;
import net.swisstech.bitly.model.v3.LinkLookup;
import net.swisstech.bitly.model.v3.LinkReferrers;
import net.swisstech.bitly.model.v3.LinkReferringDomains;
import net.swisstech.bitly.model.v3.LinkShares;
import net.swisstech.bitly.model.v3.Shorten;
import net.swisstech.bitly.model.v3.UserInfo;
import net.swisstech.bitly.model.v3.UserLinkEdit;
import net.swisstech.bitly.model.v3.UserLinkLookup;
import net.swisstech.bitly.model.v3.UserLinkSave;
import net.swisstech.bitly.test.util.AccessTokenUtil;
import net.swisstech.bitly.test.util.TestGroup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BitlyClientIntegrationTest {

	private String accessToken;

	private BitlyClient client;

	@BeforeClass
	public void beforeClass() throws IOException {
		accessToken = AccessTokenUtil.readFrom(".accesstoken");
	}

	@BeforeMethod
	public void beforeMethod() {
		client = new BitlyClient(accessToken);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callExpand() throws IOException {

		Response<Expand> resp = client.expand() //
				.addHash("api-client") //
				.addHashes("phphotoWinterSunII", "phphotoQuoVadis") //
				.addHashes(Arrays.asList("phphotoDock3", "phphotoZueriWest")) //
				.addShortUrl("http://bit.ly/LCJq0b") //
				.addShortUrls("http://bit.ly/phphotoCrossroads", "http://bit.ly/springFever") //
				.addShortUrls(Arrays.asList("http://bit.ly/phphotoBenched", "http://bit.ly/Lt5SJo")) //
				.call();

		printAndVerify(resp, Expand.class);

		assertEquals(resp.data.expand.size(), 10);
		for (Expand.Element e : resp.data.expand) {
			assertNull(e.error);
			assertNotNull(e.global_hash);
			assertNotNull(e.long_url);
			assertNotNull(e.user_hash);
			if (e.short_url == null) {
				assertNotNull(e.hash);
			}
			if (e.hash == null) {
				assertNotNull(e.short_url);
			}
		}
	}

	@Test(groups = TestGroup.INTTEST)
	public void callInfo() throws IOException {
		Response<Info> resp = client.info() //
				.setExpandUser(false) //
				.addHash("phphotoLakeZurichAtDusk") //
				.addHashes("phphotoWinterSunII", "phphotoQuoVadis") //
				.addHashes(Arrays.asList("phphotoDock3", "phphotoZueriWest")) //
				.addShortUrl("http://bit.ly/LCJq0b") //
				.addShortUrls("http://bit.ly/phphotoCrossroads", "http://bit.ly/springFever") //
				.addShortUrls(Arrays.asList("http://bit.ly/phphotoBenched", "http://bit.ly/Lt5SJo")) //
				.call();

		printAndVerify(resp, Info.class);

		assertEquals(resp.data.info.size(), 10);
		for (Info.Element i : resp.data.info) {
			assertEquals(i.created_by, "stackmagic");
			assertNotNull(i.global_hash);
			assertNotNull(i.created_at);
			assertNotNull(i.user_hash);
		}
	}

	@Test(groups = TestGroup.INTTEST)
	public void callLinkLookup() {
		Response<LinkLookup> resp = client.linkLookup() //
				.addUrl("https://www.example.com/") //
				.addUrls("https://www.example.com/1", "https://www.example.com/2") //
				.addUrls(Arrays.asList("https://www.example.com/1", "https://www.example.com/2")) //
				.call();

		printAndVerify(resp, LinkLookup.class);

		assertEquals(resp.data.link_lookup.size(), 5);
		int foundCount = 0;
		for (LinkLookup.Element lu : resp.data.link_lookup) {
			if (lu.aggregate_link != null) {
				foundCount++;
			}
		}
		assertEquals(foundCount, 1);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callShorten() throws IOException {
		Response<Shorten> resp = client.shorten() //
				.setLongUrl("https://www.example.com/") //
				.call();

		printAndVerify(resp, Shorten.class);

		assertEquals(resp.data.global_hash, "maiCS");
		assertEquals(resp.data.hash, "MvuS15");
		assertEquals(resp.data.long_url, "https://www.example.com/");
		assertEquals(resp.data.new_hash, 0);
		assertEquals(resp.data.url, "http://bit.ly/MvuS15");
	}

	@Test(groups = TestGroup.INTTEST)
	public void callUserLinkEdit() {
		// test link to https://www.example.com/bitly-api-client-test
		Response<UserLinkEdit> resp = client.userLinkEdit() //
				.setLink("http://bit.ly/MtVsf1") //
				.setNote("Note: " + System.currentTimeMillis()) //
				.setUserTs(System.currentTimeMillis()) //
				.call();

		printAndVerify(resp, UserLinkEdit.class);

		assertEquals(resp.data.link_edit.link, "http://bit.ly/MtVsf1");
	}

	@Test(groups = TestGroup.INTTEST)
	public void callUserLinkLookup() {
		Response<UserLinkLookup> resp = client.userLinkLookup() //
				.addUrl("https://www.example.com/bitly-api-client-test") //
				.call();

		printAndVerify(resp, UserLinkLookup.class);

		assertEquals(resp.data.link_lookup.size(), 1);
		assertEquals(resp.data.link_lookup.get(0).aggregate_link, "http://bit.ly/MtVsf2");
		assertEquals(resp.data.link_lookup.get(0).link, "http://bit.ly/MtVsf1");
		assertEquals(resp.data.link_lookup.get(0).url, "https://www.example.com/bitly-api-client-test");
	}

	@Test(groups = TestGroup.INTTEST)
	public void callUserLinkSaveExistingLink() {
		// must have a unique link and so we add milliseconds
		Response<UserLinkSave> resp = client.userLinkSave() //
				.setLongUrl("https://www.example.com/bitly-api-client-test") //
				.setTitle("example user link save (existing)") //
				.setNote("testing link save (existing)") //
				.setPrivate(true) //
				.setUserTs(0) //
				.call();

		printAndVerify(resp, UserLinkSave.class, 304, "LINK_ALREADY_EXISTS");

		assertEquals(resp.data.link_save.aggregate_link, "http://bit.ly/MtVsf2");
		assertEquals(resp.data.link_save.link, "http://bit.ly/MtVsf1");
		assertEquals(resp.data.link_save.long_url, "https://www.example.com/bitly-api-client-test");
		assertEquals(resp.data.link_save.new_link, 0);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callUserLinkSaveNewLink() {
		String longUrl = "https://www.example.com/bitly-api-client-test/" + System.currentTimeMillis();
		Response<UserLinkSave> resp = client.userLinkSave() //
				.setLongUrl(longUrl) //
				.setTitle("example user link save (new)") //
				.setNote("testing link save (new)") //
				.setPrivate(true) //
				.setUserTs(0) //
				.call();

		printAndVerify(resp, UserLinkSave.class);

		assertNotNull(resp.data.link_save.link);
		assertNotNull(resp.data.link_save.aggregate_link);
		assertEquals(resp.data.link_save.long_url, longUrl);
		assertEquals(resp.data.link_save.new_link, 1);

		// can't have this showing up in my history so archive it
		Response<UserLinkEdit> edit = client.userLinkEdit() //
				.setLink(resp.data.link_save.link) //
				.setArchived(true) //
				.call();

		printAndVerify(edit, UserLinkEdit.class);

		assertEquals(edit.data.link_edit.link, resp.data.link_save.link);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callLinkClicksRolledUp() {
		Response<LinkClicksRolledUp> resp = client.linkClicksRolledUp() //
				.setLink("http://bit.ly/LfXpbF") //
				.setUnit("hour") //
				.setUnits(-1) //
				.setTimezone(0) //
				.setLimit(1000) //
				.call();

		printAndVerify(resp, LinkClicksRolledUp.class);

		assertTrue(resp.data.link_clicks > 0);
		assertEquals(resp.data.tz_offset, 0);
		assertEquals(resp.data.unit, "hour");
		assertEquals(resp.data.units, -1);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callLinkClicksExpanded() {
		Response<LinkClicksExpanded> resp = client.linkClicksExpanded() //
				.setLink("http://bit.ly/LfXpbF") //
				.setUnit("hour") //
				.setUnits(-1) //
				.setTimezone(0) //
				.setLimit(1000) //
				.call();

		printAndVerify(resp, LinkClicksExpanded.class);

		assertTrue(resp.data.link_clicks.size() > 0);
		assertEquals(resp.data.tz_offset, 0);
		assertEquals(resp.data.unit, "hour");
		assertEquals(resp.data.units, -1);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callLinkCountriesExpanded() {
		Response<LinkCountriesExpanded> resp = client.linkCountriesExpanded() //
				.setLink("http://bit.ly/LfXpbF") //
				.setUnit("hour") //
				.setUnits(-1) //
				.setTimezone(0) //
				.setLimit(1000) //
				.call();

		printAndVerify(resp, LinkCountriesExpanded.class);

		assertTrue(resp.data.countries.size() > 0);
		assertEquals(resp.data.tz_offset, 0);
		assertEquals(resp.data.unit, "hour");
		assertEquals(resp.data.units, -1);
	}

	// disabled because this doesn't work as expected, the rollup parameter
	// doesn't do anything for the response format. link clicks works though.
	@Test(groups = TestGroup.INTTEST, enabled = false)
	public void callLinkCountriesRolledUp() {
		Response<LinkCountriesRolledUp> resp = client.linkCountriesRolledUp() //
				.setLink("http://bit.ly/LfXpbF") //
				.setUnit("hour") //
				.setUnits(-1) //
				.setTimezone(0) //
				.setLimit(1000) //
				.call();

		printAndVerify(resp, LinkCountriesRolledUp.class);

		assertTrue(resp.data.countries > 0);
		assertEquals(resp.data.tz_offset, 0);
		assertEquals(resp.data.unit, "hour");
		assertEquals(resp.data.units, -1);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callLinkEncodersCount() {
		Response<LinkEncodersCount> resp = client.linkEncodersCount() //
				.setLink("http://bit.ly/cJ8Hst") //
				.call();

		printAndVerify(resp, LinkEncodersCount.class);

		assertTrue(resp.data.count > 0);
		assertEquals(resp.data.aggregate_link, "http://bitly.com/CjiA");
	}

	@Test(groups = TestGroup.INTTEST)
	public void callLinkReferrers() {
		Response<LinkReferrers> resp = client.linkReferrers() //
				.setLink("http://bit.ly/LfXpbF") //
				.setUnit("hour") //
				.setUnits(-1) //
				.setTimezone(0) //
				.setLimit(1000) //
				.call();

		printAndVerify(resp, LinkReferrers.class);

		assertTrue(resp.data.referrers.size() > 0);
		assertEquals(resp.data.unit, "hour");
		assertEquals(resp.data.units, -1);
		assertEquals(resp.data.tz_offset, 0);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callLinkReferringDomains() {
		Response<LinkReferringDomains> resp = client.linkReferringDomains() //
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

	@Test(groups = TestGroup.INTTEST)
	public void callLinkShares() {
		Response<LinkShares> resp = client.linkShares() //
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

	@Test(groups = TestGroup.INTTEST)
	public void callUserInfoForAccessTokenUser() {
		Response<UserInfo> resp = client.userInfo() //
				.call();

		printAndVerify(resp, UserInfo.class);

		// you need to change this to your own user name
		assertEquals(resp.data.login, "stackmagic");
	}

	@Test(groups = TestGroup.INTTEST)
	public void callUserInfoForAnotherLogin() {
		Response<UserInfo> resp = client.userInfo() //
				.setLogin("bufferapp") //
				.call();

		printAndVerify(resp, UserInfo.class);

		assertEquals(resp.data.login, "bufferapp");
	}
}

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

import static net.swisstech.bitly.test.util.TestUtil.print;
import static net.swisstech.bitly.test.util.TestUtil.verify;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;

import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.Expand;
import net.swisstech.bitly.model.v3.Info;
import net.swisstech.bitly.model.v3.LinkLookup;
import net.swisstech.bitly.model.v3.Shorten;
import net.swisstech.bitly.model.v3.UserLinkEdit;
import net.swisstech.bitly.model.v3.UserLinkLookup;
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
				.addHash("phphotoWinterSun") //
				.addHashes("phphotoWinterSunII", "phphotoQuoVadis") //
				.addHashes(Arrays.asList("phphotoDock3", "phphotoZueriWest")) //
				.addShortUrl("http://bit.ly/LCJq0b") //
				.addShortUrls("http://bit.ly/phphotoCrossroads", "http://bit.ly/springFever") //
				.addShortUrls(Arrays.asList("http://bit.ly/phphotoBenched", "http://bit.ly/Lt5SJo")) //
				.call();

		verify(resp, Expand.class);
		print(resp);

		// TODO verify the response
	}

	@Test(groups = TestGroup.INTTEST)
	public void callInfo() throws IOException {
		Response<Info> resp = client.info() //
				.setExpandUser(false) //
				.addHash("phphotoWinterSun") //
				.addHashes("phphotoWinterSunII", "phphotoQuoVadis") //
				.addHashes(Arrays.asList("phphotoDock3", "phphotoZueriWest")) //
				.addShortUrl("http://bit.ly/LCJq0b") //
				.addShortUrls("http://bit.ly/phphotoCrossroads", "http://bit.ly/springFever") //
				.addShortUrls(Arrays.asList("http://bit.ly/phphotoBenched", "http://bit.ly/Lt5SJo")) //
				.call();

		verify(resp, Info.class);
		print(resp);

		// TODO verify the response
	}

	@Test(groups = TestGroup.INTTEST)
	public void callLinkLookup() {
		Response<LinkLookup> resp = client.linkLookup() //
				.addUrl("https://www.example.com/") //
				.addUrls("https://www.example.com/1", "https://www.example.com/2") //
				.addUrls(Arrays.asList("https://www.example.com/1", "https://www.example.com/2")) //
				.call();

		verify(resp, LinkLookup.class);
		print(resp);

		// TODO verify the response
	}

	@Test(groups = TestGroup.INTTEST)
	public void callShorten() throws IOException {
		Response<Shorten> resp = client.shorten() //
				.setLongUrl("https://www.example.com/") //
				.call();

		verify(resp, Shorten.class);
		print(resp);

		// TODO verify the response
	}

	@Test(groups = TestGroup.INTTEST)
	public void callUserLinkEdit() {
		// test link to https://www.example.com/bitly-api-client-test
		Response<UserLinkEdit> resp = client.userLinkEdit() //
				.setLink("http://bit.ly/MtVsf1") //
				.setNote("Note: " + System.currentTimeMillis()) //
				.setUserTs(System.currentTimeMillis()) //
				.call();

		verify(resp, UserLinkEdit.class);
		print(resp);

		assertEquals(resp.data.link_edit.link, "http://bit.ly/MtVsf1");
	}

	@Test(groups = TestGroup.INTTEST)
	public void callUserLinkLookup() {
		Response<UserLinkLookup> resp = client.userLinkLookup() //
				.addUrl("https://www.example.com/bitly-api-client-test") //
				.call();

		verify(resp, UserLinkLookup.class);
		print(resp);

		assertEquals(resp.data.link_lookup.size(), 1);
		assertEquals(resp.data.link_lookup.get(0).aggregate_link, "http://bit.ly/MtVsf2");
		assertEquals(resp.data.link_lookup.get(0).link, "http://bit.ly/MtVsf1");
		assertEquals(resp.data.link_lookup.get(0).url, "https://www.example.com/bitly-api-client-test");
	}
}

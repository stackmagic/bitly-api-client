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

import java.io.IOException;
import java.util.Arrays;

import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.Expand;
import net.swisstech.bitly.model.v3.Info;
import net.swisstech.bitly.model.v3.Lookup;
import net.swisstech.bitly.model.v3.ShortUrl;
import net.swisstech.bitly.test.util.AccessTokenUtil;
import net.swisstech.bitly.test.util.TestGroup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BitlyClientIntegrationTest {

	private BitlyClient client;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		String accessToken = AccessTokenUtil.readFrom(".accesstoken");
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
	}

	@Test(groups = TestGroup.INTTEST)
	public void callLookup() {
		Response<Lookup> resp = client.lookup() //
				.addUrl("https://www.example.com/") //
				.addUrls("https://www.example.com/1", "https://www.example.com/2") //
				.addUrls(Arrays.asList("https://www.example.com/1", "https://www.example.com/2")) //
				.call();

		verify(resp, Lookup.class);
		print(resp);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callShorten() throws IOException {
		Response<ShortUrl> resp = client.shorten() //
				.setLongUrl("https://www.example.com/") //
				.call();

		verify(resp, ShortUrl.class);
		print(resp);
	}

	@Test(groups = TestGroup.INTTEST)
	public void callShortenWithExtraParameters() {
		Response<ShortUrl> resp = client.shorten() //
				.setLongUrl("https://www.example.com/%s?%s=%s#%s", "test1", "test2", "test3", "test4") //
				.call();

		verify(resp, ShortUrl.class);
		print(resp);
	}
}

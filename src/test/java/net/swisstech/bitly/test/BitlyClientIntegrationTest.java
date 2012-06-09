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

import java.io.IOException;
import java.util.Arrays;

import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.Expand;
import net.swisstech.bitly.model.v3.Info;
import net.swisstech.bitly.test.util.AccessTokenUtil;
import net.swisstech.bitly.test.util.TestGroup;

import org.testng.annotations.Test;

public class BitlyClientIntegrationTest {

	@Test(groups = TestGroup.INTTEST)
	public void makeSomeTestCalls() throws IOException {

		String accessToken = AccessTokenUtil.readFrom(".accesstoken");
		BitlyClient client = new BitlyClient(accessToken);

		Response<Expand> respExpand = client.expandRequest() //
				.addHash("phphotoWinterSun") //
				.addHashes("phphotoWinterSunII", "phphotoQuoVadis") //
				.addHashes(Arrays.asList("phphotoDock3", "phphotoZueriWest")) //
				.addShortUrl("http://bit.ly/LCJq0b") //
				.addShortUrls("http://bit.ly/phphotoCrossroads", "http://bit.ly/springFever") //
				.addShortUrls(Arrays.asList("http://bit.ly/phphotoBenched", "http://bit.ly/Lt5SJo")) //
				.call();

		System.out.println(respExpand);
		System.out.println(respExpand.data);

		Response<Info> respInfo = client.infoRequest() //
				.setExpandUser(false) //
				.addHash("phphotoWinterSun") //
				.addHashes("phphotoWinterSunII", "phphotoQuoVadis") //
				.addHashes(Arrays.asList("phphotoDock3", "phphotoZueriWest")) //
				.addShortUrl("http://bit.ly/LCJq0b") //
				.addShortUrls("http://bit.ly/phphotoCrossroads", "http://bit.ly/springFever") //
				.addShortUrls(Arrays.asList("http://bit.ly/phphotoBenched", "http://bit.ly/Lt5SJo")) //
				.call();

		System.out.println(respInfo);
		System.out.println(respInfo.data);
	}
}

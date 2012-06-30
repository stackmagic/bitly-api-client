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

import java.io.IOException;
import java.util.Arrays;

import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.InfoResponse;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_info">/v3/info</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class InfoIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callInfo() throws IOException {
		Response<InfoResponse> resp = getClient().info() //
				.setExpandUser(false) //
				.addHash("phphotoLakeZurichAtDusk") //
				.addHashes("phphotoWinterSunII", "phphotoQuoVadis") //
				.addHashes(Arrays.asList("phphotoDock3", "phphotoZueriWest")) //
				.addShortUrl("http://bit.ly/LCJq0b") //
				.addShortUrls("http://bit.ly/phphotoCrossroads", "http://bit.ly/springFever") //
				.addShortUrls(Arrays.asList("http://bit.ly/phphotoBenched", "http://bit.ly/Lt5SJo")) //
				.call();

		printAndVerify(resp, InfoResponse.class);

		assertEquals(resp.data.info.size(), 10);
		for (InfoResponse.Info i : resp.data.info) {
			assertEquals(i.created_by, "stackmagic");
			assertNotNull(i.global_hash);
			assertNotNull(i.created_at);
			assertNotNull(i.user_hash);
		}
	}
}

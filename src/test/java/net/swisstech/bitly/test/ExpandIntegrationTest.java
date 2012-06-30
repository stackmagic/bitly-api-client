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

import java.io.IOException;
import java.util.Arrays;

import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.ExpandResponse;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_expand">/v3/expand</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class ExpandIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callExpand() throws IOException {
		Response<ExpandResponse> resp = getClient().expand() //
				.addHash("api-client") //
				.addHashes("phphotoWinterSunII", "phphotoQuoVadis") //
				.addHashes(Arrays.asList("phphotoDock3", "phphotoZueriWest")) //
				.addShortUrl("http://bit.ly/LCJq0b") //
				.addShortUrls("http://bit.ly/phphotoCrossroads", "http://bit.ly/springFever") //
				.addShortUrls(Arrays.asList("http://bit.ly/phphotoBenched", "http://bit.ly/Lt5SJo")) //
				.call();

		printAndVerify(resp, ExpandResponse.class);

		assertEquals(resp.data.expand.size(), 10);
		for (ExpandResponse.Expand e : resp.data.expand) {
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
}

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

import java.io.IOException;

import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.ShortenResponse;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_shorten">/v3/shorten</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class ShortenIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callShorten() throws IOException {
		Response<ShortenResponse> resp = getClient().shorten() //
				.setLongUrl("https://www.example.com/") //
				.call();

		printAndVerify(resp, ShortenResponse.class);

		assertEquals(resp.data.global_hash, "maiCS");
		assertEquals(resp.data.hash, "MvuS15");
		assertEquals(resp.data.long_url, "https://www.example.com/");
		assertEquals(resp.data.new_hash, 0);
		assertEquals(resp.data.url, "http://bit.ly/MvuS15");
	}
}

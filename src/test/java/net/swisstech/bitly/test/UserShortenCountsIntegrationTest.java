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

import static net.swisstech.bitly.test.util.AssertUtil.assertGreater;
import static net.swisstech.bitly.test.util.TestUtil.printAndVerify;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserShortenCountsExpandedResponse;
import net.swisstech.bitly.model.v3.UserShortenCountsExpandedResponse.UserShortenCount;
import net.swisstech.bitly.model.v3.UserShortenCountsRolledUpResponse;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_metrics.html#v3_user_shorten_counts">/v3/user/shorten_counts</a>
 * request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserShortenCountsIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callUserShortenCountsRolledUp() {
		Response<UserShortenCountsRolledUpResponse> resp = getClient().userShortenCountsRolledUp() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserShortenCountsRolledUpResponse.class);

		assertGreater(resp.data.user_shorten_counts, 0);
	}

	@Test
	public void callUserShortenCountsExpanded() {
		Response<UserShortenCountsExpandedResponse> resp = getClient().userShortenCountsExpanded() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserShortenCountsExpandedResponse.class);

		assertGreater(resp.data.user_shorten_counts.size(), 0);
		for (UserShortenCount usc : resp.data.user_shorten_counts) {
			assertGreater(usc.shortens, 0);
		}
	}
}

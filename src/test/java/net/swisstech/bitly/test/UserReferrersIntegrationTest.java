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
import static org.testng.Assert.assertNotNull;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserReferrersExpanded;
import net.swisstech.bitly.model.v3.UserReferrersExpanded.Referrer;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_metrics.html#v3_user_referrers">/v3/user/referrers</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserReferrersIntegrationTest extends AbstractBitlyClientIntegrationTest {

	// TODO if the unit parameter is missing, this call returns an entirely different response, and rollup has no influence

	@Test
	public void callUserReferrersExpanded() {
		Response<UserReferrersExpanded> resp = getClient().userReferersExpanded() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserReferrersExpanded.class);

		assertGreater(resp.data.user_referrers.size(), 0);
		for (Referrer r : resp.data.user_referrers) {
			assertGreater(r.clicks, 0);
			assertNotNull(r.referrer);
		}
	}
}

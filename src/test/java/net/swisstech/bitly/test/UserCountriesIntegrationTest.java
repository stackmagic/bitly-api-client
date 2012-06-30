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
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserCountriesRolledUpResponse;
import net.swisstech.bitly.model.v3.UserCountriesRolledUpResponse.UserCountry;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_metrics.html#v3_user_countries">/v3/user/countries</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserCountriesIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callUserCountriesRolledUp() {
		Response<UserCountriesRolledUpResponse> resp = getClient().userCountriesRolledUp() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserCountriesRolledUpResponse.class);

		assertGreater(resp.data.user_countries.size(), 0);
		for (UserCountry uc : resp.data.user_countries) {
			assertGreater(uc.clicks, 0);
			assertNotNull(uc.country);
			if (!"None".equals(uc.country)) {
				assertEquals(uc.country.length(), 2);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Test(expectedExceptions = UnsupportedOperationException.class, expectedExceptionsMessageRegExp = "Bitly always behaves as rollup=true for this call, use userCountriesRolledUp\\(\\) instead")
	public void callUserCountriesExpanded() {
		getClient().userCountriesExpanded();
	}
}

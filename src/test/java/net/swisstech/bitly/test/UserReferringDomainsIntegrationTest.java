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

import static org.testng.Assert.*;
import static net.swisstech.bitly.test.util.AssertUtil.*;
import static net.swisstech.bitly.test.util.TestUtil.printAndVerify;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserReferringDomainsResponse;
import net.swisstech.bitly.model.v3.UserReferringDomainsResponse.ReferringDomain;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a
 * href="http://dev.bitly.com/user_metrics.html#v3_user_referring_domains">/v3/user/referring_domains</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserReferringDomainsIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callUserReferringDomainsExpanded() {
		Response<UserReferringDomainsResponse> resp = getClient().userReferringDomainsExpanded() //
				.setUnit("hour") //
				.setUnits(-1) //
				.call();

		printAndVerify(resp, UserReferringDomainsResponse.class);

		assertGreater(resp.data.user_referring_domains.size(), 0);
		for (ReferringDomain rd : resp.data.user_referring_domains) {
			assertGreater(rd.clicks, 0);
			assertNotNull(rd.domain);
			if ("direct".equals(rd.domain)) {
				assertNull(rd.url);
			}
			else {
				assertNotNull(rd.url);
			}
		}
	}
}

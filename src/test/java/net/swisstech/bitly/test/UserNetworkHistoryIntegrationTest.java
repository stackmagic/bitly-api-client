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
import net.swisstech.bitly.model.v3.UserNetworkHistoryResponse;
import net.swisstech.bitly.model.v3.UserNetworkHistoryResponse.NetworkHistoryEntry;
import net.swisstech.bitly.model.v3.UserNetworkHistoryResponse.Save;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_info.html#v3_user_network_history">/v3/user/network_history</a>
 * request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserNetworkHistoryIntegrationTest extends AbstractBitlyClientIntegrationTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserNetworkHistoryIntegrationTest.class);

	@Test
	public void callUserNetworkHistory() {
		Response<UserNetworkHistoryResponse> resp = getClient().userNetworkHistory() //
				.call();

		printAndVerify(resp, UserNetworkHistoryResponse.class);

		assertGreater(resp.data.total, 0);
		assertGreater(resp.data.entries.size(), 0);
		LOG.debug("Received " + resp.data.entries.size() + " Entries");
		for (NetworkHistoryEntry nhe : resp.data.entries) {
			assertNotNull(nhe.global_hash);
			assertGreater(nhe.saves.size(), 0);
			LOG.debug("Entry has " + nhe.saves.size() + " Saves");
			for (Save s : nhe.saves) {
				assertNotNull(s.link);
			}
		}
	}
}

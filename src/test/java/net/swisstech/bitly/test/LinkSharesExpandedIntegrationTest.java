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
import static net.swisstech.bitly.test.util.AssertUtil.assertIn;
import static net.swisstech.bitly.test.util.TestUtil.printAndVerify;
import static org.testng.Assert.assertEquals;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.LinkSharesExpandedResponse;
import net.swisstech.bitly.model.v3.LinkSharesExpandedResponse.LinkShare;
import net.swisstech.bitly.model.v3.LinkSharesExpandedResponse.LinkShareGroup;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/link_metrics.html#v3_link_shares">/v3/link/shares</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class LinkSharesExpandedIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callLinkSharesExpanded() {
		Response<LinkSharesExpandedResponse> resp = getClient().linkSharesExpanded() //
				.setLink("http://bit.ly/LTlncm") //
				.setUnit("day") //
				.setUnits(-1) //
				.setTimezone(0) //
				.setLimit(1000) //
				.call();

		printAndVerify(resp, LinkSharesExpandedResponse.class);

		assertGreater(resp.data.shares.size(), 0);
		for (LinkShareGroup group : resp.data.shares) {
			assertGreater(group.values.size(), 0);
			for (LinkShare share : group.values) {
				assertGreater(share.shares, 0);
				assertIn(share.share_type, "tw", "fb");
			}
		}

		assertGreater(resp.data.total_shares, 0);
		assertEquals(resp.data.unit, "day");
		assertEquals(resp.data.units, -1);
		assertEquals(resp.data.tz_offset, 0);
	}
}

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
import net.swisstech.bitly.model.v3.UserClicksExpanded;
import net.swisstech.bitly.model.v3.UserClicksRolledUp;

import org.testng.annotations.Test;

public class UserClicksIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callUserClicksExpanded() {
		Response<UserClicksExpanded> resp = getClient().userClicksExpanded() //
				.setUnit("day") //
				.setUnits(500) //
				.call();

		printAndVerify(resp, UserClicksExpanded.class);

		assertGreater(resp.data.user_clicks.size(), 0);
	}

	@Test
	public void callUserClicksRolledUp() {
		Response<UserClicksRolledUp> resp = getClient().userClicksRolledUp() //
				.setUnit("day") //
				.setUnits(500) //
				.call();

		printAndVerify(resp, UserClicksRolledUp.class);
	}
}

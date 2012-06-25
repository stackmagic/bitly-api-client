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

import java.io.IOException;

import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.test.util.AccessTokenUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * <p>
 * Please note, that, in order to run, all integration tests require a file called <code>.accesstoken</code> in the root directory of the project
 * which contains a valid working access token on a single line, no newlines, nothing.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public abstract class AbstractBitlyClientIntegrationTest {

	private String accessToken;

	private BitlyClient client;

	@BeforeClass
	public void beforeClass() throws IOException {
		accessToken = AccessTokenUtil.readFrom(".accesstoken");
	}

	@BeforeMethod
	public void beforeMethod() {
		client = new BitlyClient(accessToken);
	}

	public BitlyClient getClient() {
		return client;
	}
}

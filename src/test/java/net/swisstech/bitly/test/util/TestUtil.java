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
package net.swisstech.bitly.test.util;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import net.swisstech.bitly.model.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TestUtil {

	private static final Logger LOG = LoggerFactory.getLogger(TestUtil.class);

	/** private constructor for utility class */
	private TestUtil() {
	}

	public static <T> void printAndVerify(Response<T> resp, Class<T> type) {
		printAndVerify(resp, type, 200, "OK");
	}

	public static <T> void printAndVerify(Response<T> resp, Class<T> type, long respCode, String respTxt) {
		print(resp);
		verify(resp, type, respCode, respTxt);
	}

	public static <T> void verify(Response<T> response, Class<?> type, long respCode, String respTxt) {
		assertNotNull(response);
		assertEquals(response.status_code, respCode);
		assertEquals(response.status_txt, respTxt);
		assertNotNull(response.data);
		assertEquals(response.data.getClass(), type);
	}

	public static <T> void print(Response<T> resp) {
		LOG.debug(String.format("response.status_code = %d", resp.status_code));
		LOG.debug(String.format("response.status_txt  = %s", resp.status_txt));
		LOG.debug(String.format("response.data.class  = %s", resp.data == null ? "null" : resp.data.getClass().getName()));
		LOG.debug(String.format("response.data        = %s", resp.data));
	}
}

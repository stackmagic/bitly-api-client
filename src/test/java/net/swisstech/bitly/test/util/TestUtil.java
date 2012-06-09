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

import static org.testng.Assert.*;
import net.swisstech.bitly.model.Response;

public class TestUtil {

	public static <T> void verify(Response<T> response, Class<?> type) {
		assertNotNull(response);
		assertEquals(response.status_code, 200);
		assertEquals(response.status_txt, "OK");
		assertNotNull(response.data);
		assertEquals(response.data.getClass(), type);
	}

	public static <T> void print(Response<T> response) {
		String caller = getCaller();
		System.out.println(String.format("[%s] response.status_code = %d", caller, response.status_code));
		System.out.println(String.format("[%s] response.status_txt  = %s", caller, response.status_txt));
		System.out.println(String.format("[%s] response.data.class  = %s", caller, response.data.getClass().getName()));
		System.out.println(String.format("[%s] response.data        = %s", caller, response.data));
	}

	private static String getCaller() {
		return new Exception().getStackTrace()[2].toString();
	}
}

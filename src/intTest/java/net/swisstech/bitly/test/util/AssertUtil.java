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

import java.util.Arrays;
import java.util.Collection;

/** some assertions, makes reading unit test results easier */
public class AssertUtil {

	/**
	 * Assert that the first argument is greater than the second
	 * @param first the first value
	 * @param second the second value
	 */
	public static void assertGreater(long first, long second) {
		if (first <= second) {
			throw new AssertionError(String.format("expected <%d> to be greater than <%d>", first, second));
		}
	}

	/**
	 * Assert that the actual value is part of the expected list
	 * @param actual the actual value
	 * @param expected the range of allowed values
	 */
	public static void assertIn(Object actual, Object... expected) {
		assertIn(actual, Arrays.asList(expected));
	}

	/**
	 * Assert that the actual value is part of the expected list
	 * @param actual the actual value
	 * @param expected the range of allowed values
	 */
	public static void assertIn(Object actual, Collection<?> expected) {
		for (Object ex : expected) {
			if (ex.equals(actual)) {
				return;
			}
		}
		throw new AssertionError(String.format("expected <%s> to be in %s", actual, expected));
	}
}

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
package net.swisstech.bitly.builder;

import net.swisstech.bitly.util.EncodingUtil;

class QueryParameter {

	private final String name;

	private final String value;

	public QueryParameter(String name, String value) {
		this.name = name;
		this.value = EncodingUtil.encode(value);
	}

	public QueryParameter(String name, boolean value) {
		this(name, String.valueOf(value));
	}

	public QueryParameter(String name, long value) {
		this(name, String.valueOf(value));
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("%s=%s", name, value);
	}
}

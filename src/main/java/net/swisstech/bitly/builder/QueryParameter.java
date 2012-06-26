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

/**
 * Represents a single parameter in an url query as in <code>name=value</code>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class QueryParameter {

	/** the name of the parameter */
	private final String name;

	/** the value of the parameter */
	private final String value;

	/**
	 * Constructs a new QueryParameter
	 * @param name the Name of the parameter
	 * @param value the Value of the parameter
	 */
	public QueryParameter(String name, String value) {
		this.name = name;
		this.value = EncodingUtil.encode(value);
	}

	/**
	 * Constructs a new QueryParameter
	 * @param name the Name of the parameter
	 * @param value the Value of the parameter
	 */
	public QueryParameter(String name, boolean value) {
		this(name, String.valueOf(value));
	}

	/**
	 * Constructs a new QueryParameter
	 * @param name the Name of the parameter
	 * @param value the Value of the parameter
	 */
	public QueryParameter(String name, long value) {
		this(name, String.valueOf(value));
	}

	/**
	 * Get the Name
	 * @return the Name of the parameter
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the Value
	 * @return the Value of the parameter
	 */
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("%s=%s", name, value);
	}
}

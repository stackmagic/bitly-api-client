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
package net.swisstech.bitly.model.v3;

import net.swisstech.bitly.model.ToStringSupport;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_shorten">/v3/shorten</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class ShortenResponse extends ToStringSupport {

	/**
	 * designates if this is the first time this long_url was shortened by this user. The return value will equal 1 the first time a long_url is
	 * shortened. It will also then be added to the user history
	 */
	public long new_hash;

	/** the actual link that should be used, and is a unique value for the given bitly account */
	public String url;

	/** a bitly identifier for long_url which is unique to the given account */
	public String hash;

	/** a bitly identifier for long_url which can be used to track aggregate stats across all bitly links that point to the same long_url */
	public String global_hash;

	/**
	 * an echo back of the longUrl request parameter. This may not always be equal to the URL requested, as some URL normalization may occur (e.g.,
	 * due to encoding differences, or case differences in the domain). This long_url will always be functionally identical the the request parameter
	 */
	public String long_url;
}

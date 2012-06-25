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

import java.util.List;

import net.swisstech.bitly.model.ToStringSupport;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_expand">/v3/expand</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class ExpandResponse extends ToStringSupport {

	/** list of the expanded shortUrls or hashes */
	public List<Expand> expand;

	/** an individual expanded shortUrl or hash */
	public static class Expand extends ToStringSupport {

		/** an echo back of the shortUrl request parameter */
		public String short_url;

		/** an echo back of the hash request parameter */
		public String hash;

		/** the corresponding bitly user identifier */
		public String user_hash;

		/** the corresponding bitly aggregate identifier */
		public String global_hash;

		/** indicates there was an error retrieving data for a given shortUrl or hash. An example error is "NOT_FOUND" */
		public String error;

		/** the URL that the requested short_url or hash points to */
		public String long_url;
	}
}

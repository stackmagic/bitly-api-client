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
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_user_link_lookup">/v3/user/link_lookup</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkLookupResponse extends ToStringSupport {

	/** all lookup results */
	public List<UserLinkLookup> link_lookup;

	/** single result of a link lookup */
	public static class UserLinkLookup extends ToStringSupport {

		/** an echo back of the url parameter */
		public String url;

		/** the corresponding bitly link (short URL) */
		public String link;

		/** the corresponding bitly aggregate link (global hash) */
		public String aggregate_link;
	}
}

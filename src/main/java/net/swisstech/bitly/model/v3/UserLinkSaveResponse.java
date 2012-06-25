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
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_user_link_save">/v3/user/link_save</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkSaveResponse extends ToStringSupport {

	/** result from the link save */
	public UserLinkSave link_save;

	/** result from a link save */
	public static class UserLinkSave extends ToStringSupport {

		/** the bitly short URL for the provided longUrl, specific to this user */
		public String link;

		/**
		 * a bitly short URL for the provided longUrl, which can be used to track aggregate stats across all bitly links that point to the same
		 * longUrl
		 */
		public String aggregate_link;

		/**
		 * returns <code>1</code> if the authenticated user is saving this link for the first time, <code>0</code> if the user has previously saved it
		 */
		public long new_link;

		/**
		 * an echo back of the longUrl request parameter. This may not always be equal to the URL requested, as some URL normalization may occur
		 * (e.g., due to encoding differences, or case differences in the domain). This long_url will always be functionally identical the the request
		 * parameter
		 */
		public String long_url;
	}
}

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

import net.swisstech.bitly.model.MetricsResponse;
import net.swisstech.bitly.model.ToStringSupport;

import org.joda.time.DateTime;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_metrics.html#v3_user_shorten_counts">/v3/user/shorten_counts</a>
 * request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserShortenCountsExpandedResponse extends MetricsResponse {

	/** the user shorten counts grouped by unit */
	public List<UserShortenCount> user_shorten_counts;

	/** a bucket for a single unit of time */
	public static class UserShortenCount extends ToStringSupport {

		/** a unix timestamp representing the beginning of this <code>unit</code> */
		public DateTime dt;

		/** the number of shortens made by the specified user in the specified time */
		public long shortens;
	}
}

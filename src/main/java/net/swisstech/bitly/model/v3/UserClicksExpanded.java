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
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_metrics.html#v3_user_clicks">/v3/user/clicks</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserClicksExpanded extends MetricsResponse {

	/** the aggregate number of clicks on all of the authenticated user's bitly links from other saves */
	public long total_clicks;

	/** the aggregate number of clicks on all of the authenticated user's bitly links from his own saves */
	public List<UserClick> user_clicks;

	/** a bucket for user clicks per unit */
	public static class UserClick extends ToStringSupport {

		/** a unix timestamp representing the beginning of this <code>unit</code> */
		public DateTime dt;

		/** a unix timestamp representing the beginning of the specified day (ONLY returned if <code>unit</code> is not specified) */
		public DateTime day_start;

		/** the number of clicks on this user's links in the specified timeframe */
		public long clicks;
	}
}

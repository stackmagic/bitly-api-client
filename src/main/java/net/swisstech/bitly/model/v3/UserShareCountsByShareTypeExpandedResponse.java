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
 * Please see the bit.ly documentation for the <a
 * href="http://dev.bitly.com/user_metrics.html#v3_user_share_counts_by_share_type">/v3/user/share_counts_by_share_type</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserShareCountsByShareTypeExpandedResponse extends MetricsResponse {

	/** the number of shares from this user's account for each <code>share_type</code> */
	public List<ShareCountByShareType> share_counts_by_share_type;

	/** shares by share type for a <code>unit</code> */
	public static class ShareCountByShareType extends ToStringSupport {

		/** timestamp corresponding to the specified <code>unit</code>. Included in timeseries response only if <code>rollup=false</code> */
		public DateTime dt;

		/** the shares by share type */
		public List<Share> values;
	}

	/** share count for a share type */
	public static class Share extends ToStringSupport {

		/** the type of share (twitter, email, facebook) */
		public String share_type;

		/** the number of shares of the specified type in that timeframe */
		public long shares;
	}
}

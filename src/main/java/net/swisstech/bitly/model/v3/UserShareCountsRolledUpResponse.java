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

import net.swisstech.bitly.model.MetricsResponse;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_metrics.html#v3_user_share_counts">/v3/user/share_counts</a>
 * request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserShareCountsRolledUpResponse extends MetricsResponse {

	/** the number of shares from this user's account */
	public long share_counts;
}

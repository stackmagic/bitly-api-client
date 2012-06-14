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

import org.joda.time.DateTime;

import com.google.gson.annotations.SerializedName;

public class UserLinkHistory {

	public long result_count;

	public List<UserLinkHistoryElement> link_history;

	public static class UserLinkHistoryElement {

		public String aggregate_link;

		public boolean archived;

		public DateTime created_at;

		public String link;

		public String long_url;

		public DateTime modified_at;

		@SerializedName("private")
		public boolean privat;

		public String title;

		public DateTime user_ts;

		@Override
		public String toString() {
			return String
					.format("UserLinkHistoryElement { aggregate_link=%s archived=%b created_at=%s link=%s long_url=%s modified_at=%s private=%b title=%s user_ts=%s }",
							aggregate_link, archived, created_at, link, long_url, modified_at, privat, title, user_ts);
		}
	}

	@Override
	public String toString() {
		return String.format("UserLinkHistory { result_count=%d link_history=%s }", result_count, link_history);
	}
}

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
package net.swisstech.bitly.model.v3.user;

import java.util.List;

import org.joda.time.DateTime;

import com.google.gson.annotations.SerializedName;

public class LinkHistory {

	public long result_count;

	public List<Element> link_history;

	public static class Element {

		public String aggregate_link;

		public boolean archived;

		public DateTime created_at;

		public String link;

		public String long_url;

		public DateTime modified_at;

		@SerializedName("private")
		public boolean private_;

		public String title;

		public DateTime user_ts;

		@Override
		public String toString() {
			return String.format("LinkHistoryElement { aggregate_link=%s link=%s long_url=%s private=%b }", aggregate_link, link, long_url, private_);
		}
	}

	@Override
	public String toString() {
		return String.format("LinkHistory { result_count=%d link_history=%s }", result_count, link_history);
	}

}

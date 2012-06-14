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

import com.google.gson.annotations.SerializedName;

public class UserNetworkHistory {

	public long total;

	public long limit;

	public long offset;

	public List<Entry> entries;

	public static class Entry {

		public String global_hash;

		public List<Save> saves;

		@Override
		public String toString() {
			return String.format("Entry { global_hash=%s saves=%s }", global_hash, saves);
		}
	}

	public static class Save {

		public String link;

		public String aggregate_link;

		public String long_url;

		public String user;

		public boolean archived;

		@SerializedName("private")
		public boolean privat;

		public long created_at;

		public long user_ts;

		public long modified_at;

		public String title;

		@Override
		public String toString() {
			return String.format(
					"Save { link=%s aggregate_link=%s long_url=%s user=%s archived=%b private=%b created_at=%d user_ts=%d modified_at=%d title=%s",
					link, aggregate_link, long_url, user, archived, privat, created_at, user, modified_at, title);
		}
	}

	@Override
	public String toString() {
		return String.format("UserNetworkHistory { total=%d limit=%d offset=%d entries=%s }", total, limit, offset, entries);
	}
}

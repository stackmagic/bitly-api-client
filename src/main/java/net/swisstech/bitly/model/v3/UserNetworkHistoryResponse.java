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

import org.joda.time.DateTime;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_info.html#v3_user_network_history">/v3/user/network_history</a>
 * request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserNetworkHistoryResponse extends ToStringSupport {

	/** the total number of network history results returned */
	public long total;

	/** an echo back of the <code>limit</code> parameter */
	public long limit;

	/** an echo back of the <code>offset</code> parameter */
	public long offset;

	/** the returned network history links */
	public List<NetworkHistoryEntry> entries;

	/** network history link */
	public static class NetworkHistoryEntry extends ToStringSupport {

		/** the global (aggregate) identifier of this link */
		public String global_hash;

		/** information about each time this link has been publicly saved by bitly users followed by the authenticated user */
		public List<Save> saves;
	}

	/** public save of a link */
	public static class Save extends ToStringSupport {

		/** the bitly link specific to this user and this long_url */
		public String link;

		/** the global bitly identifier for this long_url */
		public String aggregate_link;

		/** the original long URL */
		public String long_url;

		/** the bitly user who saved this link */
		public User user;

		/** a <code>true</code>/<code>false</code> value indicating whether the user has archived this link */
		public boolean archived;

		/** a <code>true</code>/<code>false</code> value indicating whether the user has made this link private */
		@SerializedName("private")
		public boolean privat;

		/** an integer unix epoch indicating when this link was shortened/encoded */
		public DateTime created_at;

		/** a user-provided timestamp for when this link was shortened/encoded, used for backfilling data */
		public DateTime user_ts;

		/** an integer unix epoch indicating when this link's metadata was last edited */
		public DateTime modified_at;

		/** the title for this link */
		public String title;
	}

	/** a user who has saved a link */
	public static class User {

		/** the login name of the user */
		public String login;

		/** the avatar_url of the user */
		public String avatar_url;

		/** display name of the user */
		public String display_name;

		/** profile url of the user */
		public String profile_url;

		/** full name of the user */
		public String full_name;
	}
}

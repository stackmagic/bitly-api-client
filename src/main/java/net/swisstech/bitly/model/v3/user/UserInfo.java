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

public class UserInfo {

	// always returned in the response
	public String login;

	public String profile_url;

	public String profile_image;

	public long member_since;

	public String full_name;

	public String display_name;

	public List<Object> share_accounts;

	// only included in requests for a user's own info
	public String apiKey;

	public boolean is_enterprise;

	public String custom_short_domain;

	public List<Object> tracking_domains;

	public String default_link_privacy;

	// only included for enterprise accounts (is_enterprise == 1)
	public List<Object> sub_accounts;

	public List<Object> e2e_domains;

	public String master_account;

	public List<Object> enterprise_permissions;

	@Override
	public String toString() {
		return String.format("Info { login=%s profile_url=%s }", login, profile_url);
	}

}

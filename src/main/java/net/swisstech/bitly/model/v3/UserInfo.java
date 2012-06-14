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
		return String.format("UserInfo { login=%s profile_url=%s profile_image=%s member_since=%d full_name=%s display_name=%s "
				+ " share_accounts=%s apiKey=%s is_enterprise=%b custom_short_domain=%s tracking_domains=%s default_link_privacy=%s"
				+ " sub_accounts=%s e2e_domains=%s master_account=%s enterprise_permissions=%s }", login, profile_url, profile_image, member_since,
				full_name, display_name, share_accounts, apiKey, is_enterprise, custom_short_domain, tracking_domains, default_link_privacy,
				sub_accounts, e2e_domains, master_account, enterprise_permissions);
	}
}

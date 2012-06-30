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

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_info.html#v3_user_info">/v3/user/info</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserInfoResponse extends ToStringSupport {

	/** the user's login (always returned in the response) */
	public String login;

	/** URL of user's profile page (always returned in the response) */
	public String profile_url;

	/** URL of user's profile image (always returned in the response) */
	public String profile_image;

	/** Unix timestamp for the moment the user signed up (always returned in the response) */
	public DateTime member_since;

	/** the user's full name, if set (optional, always returned in the response) */
	public String full_name;

	/** the user's display name, if set (optional, always returned in the response) */
	public String display_name;

	/**
	 * a list of the share accounts (Twitter or Facebook) linked to the user's account (optional, always returned in the response)
	 * 
	 * TODO substructure unclear
	 */
	public List<Object> share_accounts;

	/** the user's bitly API key (optional, only included in requests for a user's own info) */
	public String apiKey;

	/**
	 * <code>0</code> or <code>1</code> to indicate if this account is signed up for bitly enterprise (optional, only included in requests for a
	 * user's own info)
	 */
	public boolean is_enterprise;

	/**
	 * A short domain registered with this account that can be used in place of <code>bit.ly</code> for shortening links (optional, only included in
	 * requests for a user's own info)
	 */
	public String custom_short_domain;

	/**
	 * A list of domains configured for analytics tracking (optional, only included in requests for a user's own info)
	 * 
	 * TODO substructure unclear
	 */
	public List<Object> tracking_domains;

	/**
	 * <code>public</code> or <code>private</code> indicating the default privacy setting for new links (optional, only included in requests for a
	 * user's own info)
	 */
	public String default_link_privacy;

	/**
	 * list of accounts associated with this account (optional, only included for enterprise accounts (is_enterprise == 1))
	 * 
	 * TODO substructure unclear
	 */
	public List<Object> sub_accounts;

	/**
	 * list of domains associated with this <code>custom_short_domain</code> (optional, only included for enterprise accounts (is_enterprise == 1))
	 * TODO substructure unclear
	 */
	public List<Object> e2e_domains;

	/**
	 * the login of a master account, if this is associated with an enterprise account (optional, only included for enterprise accounts (is_enterprise
	 * == 1))
	 */
	public String master_account;

	/**
	 * list of enterprise permissions associated with this account (optional, only included for enterprise accounts (is_enterprise == 1))
	 * 
	 * TODO substructure unclear
	 */
	public List<Object> enterprise_permissions;
}

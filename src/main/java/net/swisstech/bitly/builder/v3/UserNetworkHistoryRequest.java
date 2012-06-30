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
package net.swisstech.bitly.builder.v3;

import java.lang.reflect.Type;

import net.swisstech.bitly.builder.Request;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserNetworkHistoryResponse;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_info.html#v3_user_network_history">/v3/user/network_history</a>
 * request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserNetworkHistoryRequest extends Request<UserNetworkHistoryResponse> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public UserNetworkHistoryRequest(String accessToken) {
		super(accessToken);

		// we just set this to true hard because the user field is reused for both the username (String, if expand_user=false) and the user (Object,
		// if expand_user=true)

		// TODO split into 2 calls following the same principle as expanded/rolledup?
		addQueryParameter("expand_user", true);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/network_history";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserNetworkHistoryResponse>>() {
		}.getType();
	}

	/**
	 * optional: set the offset
	 * @param offset integer that specifies the first record to return
	 * @return this builder
	 */
	public UserNetworkHistoryRequest setOffset(long offset) {
		addQueryParameter("offset", offset);
		return this;
	}

	/**
	 * optional: set the limit
	 * @param limit integer in the range 1;100 that specifies the number of records to return (default:20)
	 * @return this builder
	 */
	public UserNetworkHistoryRequest setLimit(long limit) {
		addQueryParameter("limit", limit);
		return this;
	}

	/**
	 * optional: set to expand the user
	 * @param expand_user <code>true|false</code> - include extra user info in response (<code>login</code>, <code>avatar_url</code>,
	 *            <code>display_name</code>, <code>profile_url</code>, <code>full_name</code>). default is <code>false</code>
	 * @return this builder
	 */
	// public UserNetworkHistoryRequest setExpandUser(boolean expand_user) {
	// addQueryParameter("expand_user", expand_user);
	// return this;
	// }
}

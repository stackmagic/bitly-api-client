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
import net.swisstech.bitly.model.v3.UserNetworkHistory;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_info.html#v3_user_network_history">/v3/user/network_history</a>
 * request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserNetworkHistoryRequest extends Request<UserNetworkHistory> {

	public UserNetworkHistoryRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/network_history";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserNetworkHistory>>() {
		}.getType();
	}

	public UserNetworkHistoryRequest setOffset(long offset) {
		addQueryParameter("offset", offset);
		return this;
	}

	public UserNetworkHistoryRequest setLimit(long limit) {
		addQueryParameter("limit", limit);
		return this;
	}

	public UserNetworkHistoryRequest setExpandUser(boolean expand_user) {
		addQueryParameter("expand_user", expand_user);
		return this;
	}
}

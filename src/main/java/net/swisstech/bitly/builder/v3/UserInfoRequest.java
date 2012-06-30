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
import net.swisstech.bitly.model.v3.UserInfoResponse;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_info.html#v3_user_info">/v3/user/info</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserInfoRequest extends Request<UserInfoResponse> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public UserInfoRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/info";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserInfoResponse>>() {
		}.getType();
	}

	/**
	 * optional: set the login
	 * @param login the bitly login of the user whose info to look up. If not given, the authenticated user will be used
	 * @return this builder
	 */
	public UserInfoRequest setLogin(String login) {
		addQueryParameter("login", login);
		return this;
	}

	/**
	 * optional: set the full name
	 * @param full_name set the users full name value. (only available for the authenticated user
	 * @return this builder
	 */
	public UserInfoRequest setFullName(String full_name) {
		addQueryParameter("full_name", full_name);
		return this;
	}
}

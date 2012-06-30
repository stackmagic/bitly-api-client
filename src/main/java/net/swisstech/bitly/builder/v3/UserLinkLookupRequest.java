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
import java.util.Collection;

import net.swisstech.bitly.builder.Request;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserLinkLookupResponse;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the <a href="http://dev.bitly.com/links.html#v3_user_link_lookup">bit.ly documentation for the /v3/user/link_lookup</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkLookupRequest extends Request<UserLinkLookupResponse> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public UserLinkLookupRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/link_lookup";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserLinkLookupResponse>>() {
		}.getType();
	}

	/**
	 * Add longUrl
	 * @param longUrl the longUrl to be looked up
	 * @return this builder
	 */
	public UserLinkLookupRequest addUrl(String longUrl) {
		addQueryParameter("url", longUrl);
		return this;
	}

	/**
	 * Add longUrls
	 * @param longUrls the longUrls to be looked up
	 * @return this builder
	 */
	public UserLinkLookupRequest addUrls(String... longUrls) {
		for (String url : longUrls) {
			addUrl(url);
		}
		return this;
	}

	/**
	 * Add longUrls
	 * @param longUrls the longUrls to be looked up
	 * @return this builder
	 */
	public UserLinkLookupRequest addUrls(Collection<String> longUrls) {
		for (String url : longUrls) {
			addUrl(url);
		}
		return this;
	}
}

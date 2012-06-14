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
package net.swisstech.bitly.builder;

import java.lang.reflect.Type;

import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserLinkHistory;

import com.google.gson.reflect.TypeToken;

public class UserLinkHistoryRequestBuilder extends RequestBuilder<UserLinkHistory> {

	public UserLinkHistoryRequestBuilder(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/link_history";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserLinkHistory>>() {
		}.getType();
	}

	public UserLinkHistoryRequestBuilder setLink(String link) {
		addQueryParameter("link", link);
		return this;
	}

	public UserLinkHistoryRequestBuilder setLimit(long limit) {
		addQueryParameter("limit", limit);
		return this;
	}

	public UserLinkHistoryRequestBuilder setOffset(long offset) {
		addQueryParameter("offset", offset);
		return this;
	}

	public UserLinkHistoryRequestBuilder setCreatedBefore(long created_before) {
		addQueryParameter("created_before", created_before);
		return this;
	}

	public UserLinkHistoryRequestBuilder setCreatedAfter(long created_after) {
		addQueryParameter("created_after", created_after);
		return this;
	}

	public UserLinkHistoryRequestBuilder setModifiedAfter(long modified_after) {
		addQueryParameter("modified_after", modified_after);
		return this;
	}

	public UserLinkHistoryRequestBuilder setArchived(boolean archived) {
		addQueryParameter("archived", archived);
		return this;
	}

	public UserLinkHistoryRequestBuilder setPrivate(boolean privat) {
		addQueryParameter("private", privat);
		return this;
	}

	public UserLinkHistoryRequestBuilder setUser(String user) {
		addQueryParameter("user", user);
		return this;
	}
}

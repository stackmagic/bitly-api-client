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
import net.swisstech.bitly.model.ApiResponse;
import net.swisstech.bitly.model.v3.UserLinkHistory;

import org.joda.time.DateTime;

import com.google.gson.reflect.TypeToken;

public class UserLinkHistoryRequest extends Request<UserLinkHistory> {

	public UserLinkHistoryRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/link_history";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<ApiResponse<UserLinkHistory>>() {
		}.getType();
	}

	public UserLinkHistoryRequest setLink(String link) {
		addQueryParameter("link", link);
		return this;
	}

	public UserLinkHistoryRequest setLimit(long limit) {
		addQueryParameter("limit", limit);
		return this;
	}

	public UserLinkHistoryRequest setOffset(long offset) {
		addQueryParameter("offset", offset);
		return this;
	}

	public UserLinkHistoryRequest setCreatedBefore(DateTime created_before) {
		addQueryParameter("created_before", created_before);
		return this;
	}

	public UserLinkHistoryRequest setCreatedAfter(DateTime created_after) {
		addQueryParameter("created_after", created_after);
		return this;
	}

	public UserLinkHistoryRequest setModifiedAfter(DateTime modified_after) {
		addQueryParameter("modified_after", modified_after);
		return this;
	}

	public UserLinkHistoryRequest setArchived(boolean archived) {
		addQueryParameter("archived", archived);
		return this;
	}

	public UserLinkHistoryRequest setPrivate(boolean privat) {
		addQueryParameter("private", privat);
		return this;
	}

	public UserLinkHistoryRequest setUser(String user) {
		addQueryParameter("user", user);
		return this;
	}
}

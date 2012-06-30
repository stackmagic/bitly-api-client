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
import net.swisstech.bitly.model.v3.UserLinkHistoryResponse;

import org.joda.time.DateTime;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_info.html#v3_user_link_history">/v3/user/link_history</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkHistoryRequest extends Request<UserLinkHistoryResponse> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public UserLinkHistoryRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/link_history";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserLinkHistoryResponse>>() {
		}.getType();
	}

	/**
	 * optional: set the link
	 * @param link the bitly link to return metadata for (when specified, overrides all other options)
	 * @return this builder
	 */
	public UserLinkHistoryRequest setLink(String link) {
		addQueryParameter("link", link);
		return this;
	}

	/**
	 * optional: set the limit
	 * @param limit integer in the range 1;100 default:50, specifying the max number of results to return
	 * @return this builder
	 */
	public UserLinkHistoryRequest setLimit(long limit) {
		addQueryParameter("limit", limit);
		return this;
	}

	/**
	 * optional: set the offset
	 * @param offset integer specifying the numbered result at which to start (for pagination)
	 * @return this builder
	 */
	public UserLinkHistoryRequest setOffset(long offset) {
		addQueryParameter("offset", offset);
		return this;
	}

	/**
	 * optional: set created_before
	 * @param created_before timestamp as an integer unix epoch
	 * @return this builder
	 */
	public UserLinkHistoryRequest setCreatedBefore(DateTime created_before) {
		addQueryParameter("created_before", created_before);
		return this;
	}

	/**
	 * optional: set created_after
	 * @param created_after timestamp as an integer unix epoch
	 * @return this builder
	 */
	public UserLinkHistoryRequest setCreatedAfter(DateTime created_after) {
		addQueryParameter("created_after", created_after);
		return this;
	}

	/**
	 * optional: set modified_after
	 * @param modified_after timestamp as an integer unix epoch
	 * @return this builder
	 */
	public UserLinkHistoryRequest setModifiedAfter(DateTime modified_after) {
		addQueryParameter("modified_after", modified_after);
		return this;
	}

	/**
	 * optional: set archived
	 * @param archived on|off|both whether to include or exclude archived history entries. (on = return only archived history entries) default: off
	 * @return this builder
	 */
	public UserLinkHistoryRequest setArchived(String archived) {
		addQueryParameter("archived", archived);
		return this;
	}

	/**
	 * optional: set privat
	 * @param privat on|off|both whether to include or exclude private history entries. (on = return only private history entries) default: both
	 * @return this builder
	 */
	public UserLinkHistoryRequest setPrivate(String privat) {
		addQueryParameter("private", privat);
		return this;
	}

	/**
	 * optional: set user
	 * @param user the user for whom to retrieve history entries (if different from authenticated user)
	 * @return this builder
	 */
	public UserLinkHistoryRequest setUser(String user) {
		addQueryParameter("user", user);
		return this;
	}
}

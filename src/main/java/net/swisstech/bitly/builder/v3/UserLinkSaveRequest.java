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
import net.swisstech.bitly.model.v3.UserLinkSaveResponse;

import org.joda.time.DateTime;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_user_link_save">/v3/user/link_save</a> request.
 * </p>
 * 
 * <p>
 * Notes (by bitly)
 * <ul>
 * <li>Long URLs should be <a href="http://en.wikipedia.org/wiki/Percent-encoding">URL-encoded</a>. You can not include a longUrl in the request that
 * has <code>&amp;</code>, <code>?</code>, <code>#</code>, or other reserved parameters without first encoding it.</li>
 * <li>Long URLs should not contain spaces: any longUrl with spaces will be rejected. All spaces should be either percent encoded <code>%20</code> or
 * plus encoded <code>+</code>. Note that tabs, newlines and trailing spaces are all indications of errors. Please remember to strip leading and
 * trailing whitespace from any user input before saving.</li>
 * <li>Long URLs must have a slash between the domain and the path component. For example, <code>http://example.com?query=parameter</code> is invalid,
 * and instead should be formatted as <code>http://example.com/?query=parameter</code></li>
 * </ul>
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkSaveRequest extends Request<UserLinkSaveResponse> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public UserLinkSaveRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/link_save";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserLinkSaveResponse>>() {
		}.getType();
	}

	/**
	 * required: set the long Url
	 * @param longUrl the URL to be saved as a bitmark
	 * @return this builder
	 */
	public UserLinkSaveRequest setLongUrl(String longUrl) {
		addQueryParameter("longUrl", longUrl);
		return this;
	}

	/**
	 * optional: set the title
	 * @param title the title of this bitmark
	 * @return
	 */
	public UserLinkSaveRequest setTitle(String title) {
		addQueryParameter("title", title);
		return this;
	}

	/**
	 * optional: set the note
	 * @param note a description of, or note about, this bitmark
	 * @return this builder
	 */
	public UserLinkSaveRequest setNote(String note) {
		addQueryParameter("note", note);
		return this;
	}

	/**
	 * optional: set if this link is private
	 * @param privat boolean <code>true</code> or <code>false</code> indicating privacy setting (defaults to user-level setting)
	 * @return this builder
	 */
	public UserLinkSaveRequest setPrivate(boolean privat) {
		addQueryParameter("privat", privat);
		return this;
	}

	/**
	 * optional: set the timestamp
	 * @param user_ts timestamp as an integer epoch
	 * @return this builder
	 */
	public UserLinkSaveRequest setUserTs(DateTime user_ts) {
		addQueryParameter("user_ts", user_ts);
		return this;
	}
}

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
import net.swisstech.bitly.model.v3.UserLinkSave;

import org.joda.time.DateTime;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_user_link_save">/v3/user/link_save</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkSaveRequest extends Request<UserLinkSave> {

	public UserLinkSaveRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/link_save";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserLinkSave>>() {
		}.getType();
	}

	public UserLinkSaveRequest setLongUrl(String longUrl) {
		addQueryParameter("longUrl", longUrl);
		return this;
	}

	public UserLinkSaveRequest setTitle(String title) {
		addQueryParameter("title", title);
		return this;
	}

	public UserLinkSaveRequest setNote(String note) {
		addQueryParameter("note", note);
		return this;
	}

	public UserLinkSaveRequest setPrivate(boolean privat) {
		addQueryParameter("privat", privat);
		return this;
	}

	public UserLinkSaveRequest setUserTs(DateTime user_ts) {
		addQueryParameter("user_ts", user_ts);
		return this;
	}
}

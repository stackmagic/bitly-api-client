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
import net.swisstech.bitly.model.v3.UserSaveCustomDomainKeywordResponse;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a
 * href="http://dev.bitly.com/links.html#v3_user_save_custom_domain_keyword">/v3/user/save_custom_domain_keyword</a> request.
 * </p>
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserSaveCustomDomainKeywordRequest extends Request<UserSaveCustomDomainKeywordResponse> {

	public UserSaveCustomDomainKeywordRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/save_custom_domain_keyword";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserSaveCustomDomainKeywordResponse>>() {}.getType();
	}

	public UserSaveCustomDomainKeywordRequest setKeyword_link(String keyword_link) {
		addQueryParameter("keyword_link", keyword_link);
		return this;
	}

	public UserSaveCustomDomainKeywordRequest setTarget_link(String target_link) {
		addQueryParameter("target_link", target_link);
		return this;
	}

	public UserSaveCustomDomainKeywordRequest setOverwrite(boolean overwrite) {
		addQueryParameter("overwrite", overwrite);
		return this;
	}
}

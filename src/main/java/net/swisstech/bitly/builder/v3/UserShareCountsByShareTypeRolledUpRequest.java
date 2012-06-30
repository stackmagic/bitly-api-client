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

import net.swisstech.bitly.builder.MetricsRolledUpRequest;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserShareCountsByShareTypeRolledUpResponse;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a
 * href="http://dev.bitly.com/user_metrics.html#v3_user_share_counts_by_share_type">/v3/user/share_counts_by_share_type</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserShareCountsByShareTypeRolledUpRequest extends
		MetricsRolledUpRequest<UserShareCountsByShareTypeRolledUpRequest, UserShareCountsByShareTypeRolledUpResponse> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public UserShareCountsByShareTypeRolledUpRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/share_counts_by_share_type";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<UserShareCountsByShareTypeRolledUpResponse>>() {
		}.getType();
	}
}

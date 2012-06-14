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
import net.swisstech.bitly.model.ApiResponse;
import net.swisstech.bitly.model.v3.LinkLookup;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_link_lookup">/v3/link/lookup</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class LinkLookupRequest extends Request<LinkLookup> {

	public LinkLookupRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/link/lookup";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<ApiResponse<LinkLookup>>() {
		}.getType();
	}

	public LinkLookupRequest addUrl(String shortUrl) {
		addQueryParameter("url", shortUrl);
		return this;
	}

	public LinkLookupRequest addUrls(String... shortUrls) {
		for (String shortUrl : shortUrls) {
			addUrl(shortUrl);
		}
		return this;
	}

	public LinkLookupRequest addUrls(Collection<String> shortUrls) {
		for (String shortUrl : shortUrls) {
			addUrl(shortUrl);
		}
		return this;
	}
}

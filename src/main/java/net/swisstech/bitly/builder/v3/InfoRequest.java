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

import net.swisstech.bitly.builder.RequestBuilder;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.Info;

import com.google.gson.reflect.TypeToken;

public class InfoRequest extends RequestBuilder<Info> {

	public InfoRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/info";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<Info>>() {
		}.getType();
	}

	public InfoRequest setExpandUser(boolean expand) {
		addQueryParameter("expand_user", expand);
		return this;
	}

	public InfoRequest addHash(String hash) {
		addQueryParameter("hash", hash);
		return this;
	}

	public InfoRequest addHashes(String... hashes) {
		for (String hash : hashes) {
			addHash(hash);
		}
		return this;
	}

	public InfoRequest addHashes(Collection<String> hashes) {
		for (String hash : hashes) {
			addHash(hash);
		}
		return this;
	}

	public InfoRequest addShortUrl(String shortUrl) {
		addQueryParameter("shortUrl", shortUrl);
		return this;
	}

	public InfoRequest addShortUrls(String... shortUrls) {
		for (String shortUrl : shortUrls) {
			addShortUrl(shortUrl);
		}
		return this;
	}

	public InfoRequest addShortUrls(Collection<String> shortUrls) {
		for (String shortUrl : shortUrls) {
			addShortUrl(shortUrl);
		}
		return this;
	}
}

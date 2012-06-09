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

import java.util.Collection;

import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.Info;

public class InfoRequestBuilder extends RequestBuilder<Info> {

	public InfoRequestBuilder(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/info";
	}

	public InfoRequestBuilder setExpandUser(boolean expand) {
		addQueryParameter("expand_user", expand);
		return this;
	}

	public InfoRequestBuilder addHash(String hash) {
		addQueryParameter("hash", hash);
		return this;
	}

	public InfoRequestBuilder addHashes(String... hashes) {
		for (String hash : hashes) {
			addHash(hash);
		}
		return this;
	}

	public InfoRequestBuilder addHashes(Collection<String> hashes) {
		for (String hash : hashes) {
			addHash(hash);
		}
		return this;
	}

	public InfoRequestBuilder addShortUrl(String shortUrl) {
		addQueryParameter("shortUrl", shortUrl);
		return this;
	}

	public InfoRequestBuilder addShortUrls(String... shortUrls) {
		for (String shortUrl : shortUrls) {
			addShortUrl(shortUrl);
		}
		return this;
	}

	public InfoRequestBuilder addShortUrls(Collection<String> shortUrls) {
		for (String shortUrl : shortUrls) {
			addShortUrl(shortUrl);
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public Response<Info> call() {
		return (Response<Info>) callInternal();
	}
}

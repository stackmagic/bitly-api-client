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
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.Expand;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_expand">/v3/expand</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class ExpandRequest extends Request<Expand> {

	public ExpandRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/expand";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<Expand>>() {
		}.getType();
	}

	public ExpandRequest addHash(String hash) {
		addQueryParameter("hash", hash);
		return this;
	}

	public ExpandRequest addHashes(String... hashes) {
		for (String hash : hashes) {
			addHash(hash);
		}
		return this;
	}

	public ExpandRequest addHashes(Collection<String> hashes) {
		for (String hash : hashes) {
			addHash(hash);
		}
		return this;
	}

	public ExpandRequest addShortUrl(String shortUrl) {
		addQueryParameter("shortUrl", shortUrl);
		return this;
	}

	public ExpandRequest addShortUrls(String... shortUrls) {
		for (String shortUrl : shortUrls) {
			addShortUrl(shortUrl);
		}
		return this;
	}

	public ExpandRequest addShortUrls(Collection<String> shortUrls) {
		for (String shortUrl : shortUrls) {
			addShortUrl(shortUrl);
		}
		return this;
	}
}

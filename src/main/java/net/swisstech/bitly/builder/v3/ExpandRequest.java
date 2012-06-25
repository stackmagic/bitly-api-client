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
import net.swisstech.bitly.model.v3.ExpandResponse;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_expand">/v3/expand</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class ExpandRequest extends Request<ExpandResponse> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public ExpandRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/expand";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<ExpandResponse>>() {
		}.getType();
	}
	/**
	 * Add a hash
	 * @param hash refers to one or more bitly hashes, (e.g.: 2bYgqR or a-custom-name )
	 * @return this builder
	 */

	public ExpandRequest addHash(String hash) {
		addQueryParameter("hash", hash);
		return this;
	}

	/**
	 * Add hashes
	 * @param hashes refers to one or more bitly hashes, (e.g.: 2bYgqR or a-custom-name )
	 * @return this builder
	 */
	public ExpandRequest addHashes(String... hashes) {
		for (String hash : hashes) {
			addHash(hash);
		}
		return this;
	}

	/**
	 * Add hashes
	 * @param hashes refers to one or more bitly hashes, (e.g.: 2bYgqR or a-custom-name )
	 * @return this builder
	 */
	public ExpandRequest addHashes(Collection<String> hashes) {
		for (String hash : hashes) {
			addHash(hash);
		}
		return this;
	}

	/**
	 * Add shortUrl
	 * @param shortUrl refers to one or more bitly links e.g.: http://bit.ly/1RmnUT or http://j.mp/1RmnUT
	 * @return this builder
	 */
	public ExpandRequest addShortUrl(String shortUrl) {
		addQueryParameter("shortUrl", shortUrl);
		return this;
	}

	/**
	 * Add shortUrls
	 * @param shortUrls refers to one or more bitly links e.g.: http://bit.ly/1RmnUT or http://j.mp/1RmnUT
	 * @return this builder
	 */
	public ExpandRequest addShortUrls(String... shortUrls) {
		for (String shortUrl : shortUrls) {
			addShortUrl(shortUrl);
		}
		return this;
	}

	/**
	 * Add shortUrls
	 * @param shortUrls refers to one or more bitly links e.g.: http://bit.ly/1RmnUT or http://j.mp/1RmnUT
	 * @return this builder
	 */
	public ExpandRequest addShortUrls(Collection<String> shortUrls) {
		for (String shortUrl : shortUrls) {
			addShortUrl(shortUrl);
		}
		return this;
	}
}

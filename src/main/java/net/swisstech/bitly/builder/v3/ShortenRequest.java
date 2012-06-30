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
import net.swisstech.bitly.model.v3.ShortenResponse;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_shorten">/v3/shorten</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class ShortenRequest extends Request<ShortenResponse> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public ShortenRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/shorten";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<ShortenResponse>>() {
		}.getType();
	}

	/**
	 * URL to be shortened
	 * @param longUrl a long URL to be shortened (example: http://betaworks.com/)
	 * @return this builder
	 */
	public ShortenRequest setLongUrl(String longUrl) {
		addQueryParameter("longUrl", longUrl);
		return this;
	}

	/**
	 * <p>
	 * (optional) refers to a preferred domain; either bit.ly, j.mp, or bitly.com, for users who do NOT have a custom short domain set up with bitly.
	 * This affects the output value of url. The default for this parameter is the short domain selected by each user in his/her bitly account
	 * settings. Passing a specific domain via this parameter will override the default settings for users who do NOT have a custom short domain set
	 * up with bitly. For users who have implemented a custom short domain, bitly will always return short links according to the user's account-level
	 * preference.
	 * </p>
	 * 
	 * <p>
	 * Notes (by bitly)
	 * <ul>
	 * <li>Long URLs should be <a href="http://en.wikipedia.org/wiki/Percent-encoding">URL-encoded</a>. You can not include a longUrl in the request
	 * that has <code>&amp;</code>, <code>?</code>, <code>#</code>, or other reserved parameters without first encoding it.</li>
	 * <li>Long URLs should not contain spaces: any longUrl with spaces will be rejected. All spaces should be either percent encoded <code>%20</code>
	 * or plus encoded <code>+</code>. Note that tabs, newlines and trailing spaces are all indications of errors. Please remember to strip leading
	 * and trailing whitespace from any user input before shortening.</li>
	 * <li>Long URLs must have a slash between the domain and the path component. For example, <code>http://example.com?query=parameter</code> is
	 * invalid, and instead should be formatted as <code>http://example.com/?query=parameter</code></li>
	 * <li>The default value for the <code>domain</code> parameter is selected by each user from within his/her bitly account settings at <a
	 * href="http://bitly.com/a/account">http://bitly.com/a/account</a></li>
	 * </ul>
	 * </p>
	 * 
	 * @param domain the domain for the short url
	 * @return this builder
	 */
	public ShortenRequest setDomain(String domain) {
		addQueryParameter("domain", domain);
		return this;
	}
}

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
package net.swisstech.bitly;

import net.swisstech.bitly.builder.ExpandRequestBuilder;
import net.swisstech.bitly.builder.InfoRequestBuilder;
import net.swisstech.bitly.builder.LinkClicksExpandedRequestBuilder;
import net.swisstech.bitly.builder.LinkClicksRolledUpRequestBuilder;
import net.swisstech.bitly.builder.LinkCountriesExpandedRequestBuilder;
import net.swisstech.bitly.builder.LinkCountriesRolledUpRequestBuilder;
import net.swisstech.bitly.builder.LinkLookupRequestBuilder;
import net.swisstech.bitly.builder.ShortenRequestBuilder;
import net.swisstech.bitly.builder.UserLinkEditRequestBuilder;
import net.swisstech.bitly.builder.UserLinkLookupRequestBuilder;
import net.swisstech.bitly.builder.UserLinkSaveRequestBuilder;

public class BitlyClient {

	private final String accessToken;

	public BitlyClient(String accessToken) {
		this.accessToken = accessToken;
	}

	public ExpandRequestBuilder expand() {
		return new ExpandRequestBuilder(accessToken);
	}

	public InfoRequestBuilder info() {
		return new InfoRequestBuilder(accessToken);
	}

	public LinkLookupRequestBuilder linkLookup() {
		return new LinkLookupRequestBuilder(accessToken);
	}

	public ShortenRequestBuilder shorten() {
		return new ShortenRequestBuilder(accessToken);
	}

	public UserLinkEditRequestBuilder userLinkEdit() {
		return new UserLinkEditRequestBuilder(accessToken);
	}

	public UserLinkLookupRequestBuilder userLinkLookup() {
		return new UserLinkLookupRequestBuilder(accessToken);
	}

	public UserLinkSaveRequestBuilder userLinkSave() {
		return new UserLinkSaveRequestBuilder(accessToken);
	}

	public LinkClicksRolledUpRequestBuilder linkClicksRolledUp() {
		return new LinkClicksRolledUpRequestBuilder(accessToken);
	}

	public LinkClicksExpandedRequestBuilder linkClicksExpanded() {
		return new LinkClicksExpandedRequestBuilder(accessToken);
	}

	public LinkCountriesExpandedRequestBuilder linkCountriesExpanded() {
		return new LinkCountriesExpandedRequestBuilder(accessToken);
	}

	/**
	 * don't use this call will fail because the api behaves strange, linkclicks
	 * rollup works as expected
	 */
	@Deprecated
	public LinkCountriesRolledUpRequestBuilder linkCountriesRolledUp() {
		return new LinkCountriesRolledUpRequestBuilder(accessToken);
	}
}

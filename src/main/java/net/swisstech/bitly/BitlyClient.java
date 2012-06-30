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

import net.swisstech.bitly.builder.v3.ExpandRequest;
import net.swisstech.bitly.builder.v3.InfoRequest;
import net.swisstech.bitly.builder.v3.LinkClicksExpandedRequest;
import net.swisstech.bitly.builder.v3.LinkClicksRolledUpRequest;
import net.swisstech.bitly.builder.v3.LinkCountriesExpandedRequest;
import net.swisstech.bitly.builder.v3.LinkEncodersCountRequest;
import net.swisstech.bitly.builder.v3.LinkLookupRequest;
import net.swisstech.bitly.builder.v3.LinkReferrersRequest;
import net.swisstech.bitly.builder.v3.LinkReferringDomainsRequest;
import net.swisstech.bitly.builder.v3.LinkSharesExpandedRequest;
import net.swisstech.bitly.builder.v3.LinkSharesRolledUpRequest;
import net.swisstech.bitly.builder.v3.ShortenRequest;
import net.swisstech.bitly.builder.v3.UserClicksExpandedRequest;
import net.swisstech.bitly.builder.v3.UserClicksRolledUpRequest;
import net.swisstech.bitly.builder.v3.UserCountriesRolledUpRequest;
import net.swisstech.bitly.builder.v3.UserInfoRequest;
import net.swisstech.bitly.builder.v3.UserLinkEditRequest;
import net.swisstech.bitly.builder.v3.UserLinkHistoryRequest;
import net.swisstech.bitly.builder.v3.UserLinkLookupRequest;
import net.swisstech.bitly.builder.v3.UserLinkSaveRequest;
import net.swisstech.bitly.builder.v3.UserNetworkHistoryRequest;
import net.swisstech.bitly.builder.v3.UserPopularLinksRequest;
import net.swisstech.bitly.builder.v3.UserReferrersExpandedRequest;
import net.swisstech.bitly.builder.v3.UserReferringDomainsRequest;
import net.swisstech.bitly.builder.v3.UserShareCountsByShareTypeExpandedRequest;
import net.swisstech.bitly.builder.v3.UserShareCountsByShareTypeRolledUpRequest;
import net.swisstech.bitly.builder.v3.UserShareCountsExpandedRequest;
import net.swisstech.bitly.builder.v3.UserShareCountsRolledUpRequest;
import net.swisstech.bitly.builder.v3.UserShortenCountsExpandedRequest;
import net.swisstech.bitly.builder.v3.UserShortenCountsRolledUpRequest;
import net.swisstech.bitly.builder.v3.UserTrackingDomainListRequest;

public class BitlyClient {

	private final String accessToken;

	public BitlyClient(String accessToken) {
		this.accessToken = accessToken;
	}

	public ExpandRequest expand() {
		return new ExpandRequest(accessToken);
	}

	public InfoRequest info() {
		return new InfoRequest(accessToken);
	}

	public LinkLookupRequest linkLookup() {
		return new LinkLookupRequest(accessToken);
	}

	public ShortenRequest shorten() {
		return new ShortenRequest(accessToken);
	}

	public UserLinkEditRequest userLinkEdit() {
		return new UserLinkEditRequest(accessToken);
	}

	public UserLinkLookupRequest userLinkLookup() {
		return new UserLinkLookupRequest(accessToken);
	}

	public UserLinkSaveRequest userLinkSave() {
		return new UserLinkSaveRequest(accessToken);
	}

	public LinkClicksRolledUpRequest linkClicksRolledUp() {
		return new LinkClicksRolledUpRequest(accessToken);
	}

	public LinkClicksExpandedRequest linkClicksExpanded() {
		return new LinkClicksExpandedRequest(accessToken);
	}

	public LinkCountriesExpandedRequest linkCountriesExpanded() {
		return new LinkCountriesExpandedRequest(accessToken);
	}

	public LinkEncodersCountRequest linkEncodersCount() {
		return new LinkEncodersCountRequest(accessToken);
	}

	public LinkReferrersRequest linkReferrers() {
		return new LinkReferrersRequest(accessToken);
	}

	public LinkReferringDomainsRequest linkReferringDomains() {
		return new LinkReferringDomainsRequest(accessToken);
	}

	public LinkSharesExpandedRequest linkSharesExpanded() {
		return new LinkSharesExpandedRequest(accessToken);
	}

	public LinkSharesRolledUpRequest linkSharesRolledUp() {
		return new LinkSharesRolledUpRequest(accessToken);
	}

	public UserInfoRequest userInfo() {
		return new UserInfoRequest(accessToken);
	}

	public UserLinkHistoryRequest userLinkHistory() {
		return new UserLinkHistoryRequest(accessToken);
	}

	public UserNetworkHistoryRequest userNetworkHistory() {
		return new UserNetworkHistoryRequest(accessToken);
	}

	public UserTrackingDomainListRequest userTrackingDomainList() {
		return new UserTrackingDomainListRequest(accessToken);
	}

	public UserClicksExpandedRequest userClicksExpanded() {
		return new UserClicksExpandedRequest(accessToken);
	}

	public UserClicksRolledUpRequest userClicksRolledUp() {
		return new UserClicksRolledUpRequest(accessToken);
	}

	/**
	 * <b>Note:</b> Contrary to the documentation, rollup always seems to behave as <code>true</code> for this call (no per-unit data returned, just
	 * the sum per country).
	 * @return
	 */
	@Deprecated
	public UserCountriesRolledUpRequest userCountriesExpanded() {
		throw new UnsupportedOperationException("Bitly always behaves as rollup=true for this call, use userCountriesRolledUp() instead");
	}

	public UserCountriesRolledUpRequest userCountriesRolledUp() {
		return new UserCountriesRolledUpRequest(accessToken);
	}

	public UserPopularLinksRequest userPopularLinksExpanded() {
		return new UserPopularLinksRequest(accessToken);
	}

	public UserReferrersExpandedRequest userReferersExpanded() {
		return new UserReferrersExpandedRequest(accessToken);
	}

	public UserReferringDomainsRequest userReferringDomainsExpanded() {
		return new UserReferringDomainsRequest(accessToken);
	}

	public UserShareCountsExpandedRequest userShareCountsExpanded() {
		return new UserShareCountsExpandedRequest(accessToken);
	}

	public UserShareCountsRolledUpRequest userShareCountsRolledUp() {
		return new UserShareCountsRolledUpRequest(accessToken);
	}

	public UserShareCountsByShareTypeExpandedRequest userShareCountryByShareTypeExpanded() {
		return new UserShareCountsByShareTypeExpandedRequest(accessToken);
	}

	public UserShareCountsByShareTypeRolledUpRequest userShareCountryByShareTypeRolledUp() {
		return new UserShareCountsByShareTypeRolledUpRequest(accessToken);
	}

	public UserShortenCountsExpandedRequest userShortenCountsExpanded() {
		return new UserShortenCountsExpandedRequest(accessToken);
	}

	public UserShortenCountsRolledUpRequest userShortenCountsRolledUp() {
		return new UserShortenCountsRolledUpRequest(accessToken);
	}
}

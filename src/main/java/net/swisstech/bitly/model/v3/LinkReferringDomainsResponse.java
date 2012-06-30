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
package net.swisstech.bitly.model.v3;

import java.util.List;

import net.swisstech.bitly.model.MetricsResponse;
import net.swisstech.bitly.model.ToStringSupport;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/link_metrics.html#v3_link_referring_domains" >/v3/link/referring_domains
 * </a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class LinkReferringDomainsResponse extends MetricsResponse {

	/** list of referring domains with click counts */
	public List<LinkReferringDomain> referring_domains;

	/** a single referring domain to a link with click counts */
	public static class LinkReferringDomain extends ToStringSupport {

		/** the number of clicks referred from this domain */
		public long clicks;

		/** the domain referring clicks */
		public String domain;

		/** the complete URL of the domain referring clicks */
		public String url;
	}
}

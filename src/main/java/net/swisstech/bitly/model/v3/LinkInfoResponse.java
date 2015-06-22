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

import net.swisstech.bitly.model.AbstractTag;
import net.swisstech.bitly.model.ToStringSupport;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/data_apis.html#v3_link_info">/v3/link/info</a> request.
 * </p>
 * @author Patrick Huber (gmail: stackmagic)
 */
public class LinkInfoResponse extends ToStringSupport {

	public String canonical_url;
	public String category;
	public long content_length;
	public String aggregate_link;
	public String content_type;
	public String domain;
	public String favicon_url;
	public String global_hash;
	public String html_title;
	public int http_code;
	public long indexed;
	public List<LinktagOther> linktags_other;
	public List<MetatagName> metatags_name;
	public String original_url;
	public boolean robots_allowed;
	public String source_domain;
	public String url;
	public String url_fetched;

	public static class LinktagOther extends AbstractTag {}

	public static class MetatagName extends AbstractTag {}
}

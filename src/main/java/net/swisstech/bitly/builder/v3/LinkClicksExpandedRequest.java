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

import net.swisstech.bitly.builder.RequestBuilder;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.LinkClicksExpanded;

import com.google.gson.reflect.TypeToken;

public class LinkClicksExpandedRequest extends RequestBuilder<LinkClicksExpanded> {

	public LinkClicksExpandedRequest(String accessToken) {
		super(accessToken);
		addQueryParameter("rollup", false);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/link/clicks";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<LinkClicksExpanded>>() {
		}.getType();
	}

	public LinkClicksExpandedRequest setLink(String link) {
		addQueryParameter("link", link);
		return this;
	}

	public LinkClicksExpandedRequest setUnit(String unit) {
		addQueryParameter("unit", unit);
		return this;
	}

	public LinkClicksExpandedRequest setUnits(long units) {
		addQueryParameter("units", units);
		return this;
	}

	public LinkClicksExpandedRequest setTimezone(long timezone) {
		addQueryParameter("timezone", timezone);
		return this;
	}

	public LinkClicksExpandedRequest setLimit(long limit) {
		addQueryParameter("limit", limit);
		return this;
	}

	public LinkClicksExpandedRequest setUnitReferenceTs(long unit_reference_ts) {
		addQueryParameter("unit_reference_ts", unit_reference_ts);
		return this;
	}
}

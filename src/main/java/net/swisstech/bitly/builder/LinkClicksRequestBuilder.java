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

import java.lang.reflect.Type;

import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.LinkClicks;

import com.google.gson.reflect.TypeToken;

public class LinkClicksRequestBuilder extends RequestBuilder<LinkClicks> {

	public LinkClicksRequestBuilder(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/link/clicks";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<LinkClicks>>() {
		}.getType();
	}

	public LinkClicksRequestBuilder setLink(String link) {
		addQueryParameter("link", link);
		return this;
	}

	public LinkClicksRequestBuilder setUnit(String unit) {
		addQueryParameter("unit", unit);
		return this;
	}

	public LinkClicksRequestBuilder setUnits(long units) {
		addQueryParameter("units", units);
		return this;
	}

	public LinkClicksRequestBuilder setTimezone(long timezone) {
		addQueryParameter("timezone", timezone);
		return this;
	}

	public LinkClicksRequestBuilder setRollup(boolean rollup) {
		addQueryParameter("rollup", rollup);
		return this;
	}

	public LinkClicksRequestBuilder setLimit(long limit) {
		addQueryParameter("limit", limit);
		return this;
	}

	public LinkClicksRequestBuilder setUnitReferenceTs(long unit_reference_ts) {
		addQueryParameter("unit_reference_ts", unit_reference_ts);
		return this;
	}
}

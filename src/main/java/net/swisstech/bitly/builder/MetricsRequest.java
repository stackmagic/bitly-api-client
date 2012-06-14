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

/**
 * <p>
 * Base Request for all Requests that have the common
 * link/unit/units/timezone/limit/unit_reference_ts parameters. Uses two generic
 * types for the return type so we can keep the fluent builder pattern and for
 * the data type.
 * </p>
 * 
 * @param <REQ_TYPE> Type of the Request Builder
 * @param <DATA_TYPE> Type of the Response DTO
 */
public abstract class MetricsRequest<REQ_TYPE extends MetricsRequest<REQ_TYPE, DATA_TYPE>, DATA_TYPE> extends Request<DATA_TYPE> {

	public MetricsRequest(String accessToken, boolean rollup) {
		super(accessToken);
		addQueryParameter("rollup", rollup);
	}

	@SuppressWarnings("unchecked")
	public REQ_TYPE setLink(String link) {
		addQueryParameter("link", link);
		return (REQ_TYPE) this;
	}

	@SuppressWarnings("unchecked")
	public REQ_TYPE setUnit(String unit) {
		addQueryParameter("unit", unit);
		return (REQ_TYPE) this;
	}

	@SuppressWarnings("unchecked")
	public REQ_TYPE setUnits(long units) {
		addQueryParameter("units", units);
		return (REQ_TYPE) this;
	}

	@SuppressWarnings("unchecked")
	public REQ_TYPE setTimezone(long timezone) {
		addQueryParameter("timezone", timezone);
		return (REQ_TYPE) this;
	}

	@SuppressWarnings("unchecked")
	public REQ_TYPE setLimit(long limit) {
		addQueryParameter("limit", limit);
		return (REQ_TYPE) this;
	}

	@SuppressWarnings("unchecked")
	public REQ_TYPE setUnitReferenceTs(long unit_reference_ts) {
		addQueryParameter("unit_reference_ts", unit_reference_ts);
		return (REQ_TYPE) this;
	}
}

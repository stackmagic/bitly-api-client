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

import org.joda.time.DateTime;

/**
 * <p>
 * Base Request for all Metrics Requests that have the common link/unit/units/timezone/limit/unit_reference_ts parameters. Uses two generic types for
 * the return type (so we can keep the fluent builder pattern) and for the data type.
 * </p>
 * 
 * @param <REQ> Type of the Request Builder
 * @param <DATA> Type of the Response DTO
 */
public abstract class MetricsRequest<REQ extends MetricsRequest<REQ, DATA>, DATA> extends Request<DATA> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public MetricsRequest(String accessToken) {
		super(accessToken);
	}

	/**
	 * set the link
	 * 
	 * TODO this isn't used/allowed in all metrics requests!
	 * 
	 * @param link a bitly link
	 * @return this builder
	 */
	@SuppressWarnings("unchecked")
	public REQ setLink(String link) {
		addQueryParameter("link", link);
		return (REQ) this;
	}

	/**
	 * set the unit
	 * @param unit <code>minute</code> | <code>hour</code> | <code>day</code> | <code>week</code> | <code>month</code> default:<code>day</code> <br/>
	 *            <strong>Note:</strong> when <code>unit</code> is <code>minute</code> the maximum value for <code>units</code> is <code>60</code>
	 * @return this builder
	 */
	@SuppressWarnings("unchecked")
	public REQ setUnit(String unit) {
		addQueryParameter("unit", unit);
		return (REQ) this;
	}

	/**
	 * set the units
	 * @param units an integer representing the time units to query data for. pass <code>-1</code> to return all units of time
	 * @return this builder
	 */
	@SuppressWarnings("unchecked")
	public REQ setUnits(long units) {
		addQueryParameter("units", units);
		return (REQ) this;
	}

	/**
	 * set the timezone
	 * @param timezone an integer hour offset from UTC (-12..12), or a timezone string default:<code>America/New_York</code>
	 * @return this builder
	 */
	@SuppressWarnings("unchecked")
	public REQ setTimezone(long timezone) {
		addQueryParameter("timezone", timezone);
		return (REQ) this;
	}

	/**
	 * set the limit
	 * @param limit 1..1000 (default=100)
	 * @return this builder
	 */
	@SuppressWarnings("unchecked")
	public REQ setLimit(long limit) {
		addQueryParameter("limit", limit);
		return (REQ) this;
	}

	/**
	 * set the newest point in time from where to fetch data backwards into the past
	 * @param unit_reference_ts an epoch timestamp, indicating the most recent time for which to pull metrics. default:<code>now</code> <br/>
	 *            <strong>Note:</strong> the value of <code>unit_reference_ts</code> rounds to the nearest <code>unit</code>. <br/>
	 *            <strong>Note:</strong> historical data is stored hourly beyond the most recent 60 minutes. If a <code>unit_reference_ts</code> is
	 *            specified, <code>unit</code> cannot be <code>minute</code>
	 * @return this builder
	 */
	@SuppressWarnings("unchecked")
	public REQ setUnitReferenceTs(DateTime unit_reference_ts) {
		addQueryParameter("unit_reference_ts", unit_reference_ts);
		return (REQ) this;
	}
}

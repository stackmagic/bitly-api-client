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
 * Base Request for all Expanded Metrics Requests that have the common link/unit/units/timezone/limit/unit_reference_ts parameters. Uses two generic
 * types for the return type (so we can keep the fluent builder pattern) and for the data type.
 * </p>
 * 
 * @param <REQ> Type of the Request Builder
 * @param <DATA> Type of the Response DTO
 */
public abstract class MetricsExpandedRequest<REQ extends MetricsExpandedRequest<REQ, DATA>, DATA> extends MetricsRequest<REQ, DATA> {

	/**
	 * Create a new request builder
	 * @param accessToken the access token to access the bitly api
	 */
	public MetricsExpandedRequest(String accessToken) {
		super(accessToken);
		addQueryParameter("rollup", false);
	}
}

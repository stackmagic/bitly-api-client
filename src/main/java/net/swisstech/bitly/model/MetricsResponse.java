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
package net.swisstech.bitly.model;

/**
 * <p>
 * base response for all responses that return some form of metrics. they all have largely the same parameters.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public abstract class MetricsResponse extends ToStringSupport {

	/** the offset for the specified <code>timezone</code>, in hours */
	public long tz_offset;

	/** an echo of the specified <code>units</code> value */
	public long units;

	/** an echo of the specified <code>unit</code> value */
	public String unit;

	/** the number of days for which data is provided (ONLY returned if unit is not specified) <b>and only for some requests!</b> */
	public long days;
}

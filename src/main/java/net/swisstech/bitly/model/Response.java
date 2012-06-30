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
 * Base response from the API. If the <code>status_code</code> or <code>status_txt</code> contain an error, it's very likely, that the
 * <code>data</code> field will be null or may contain garbage.
 * </p>
 * 
 * <p>
 * For more information on the base formats please see the <a href="http://dev.bitly.com/formats.html">bit.ly documentation on formats<O/a>.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 * 
 * @param <T> Type of the Response
 */
public class Response<T> extends ToStringSupport {

	/**
	 * The status_code is 200 for a successful request, 403 when rate limited, 503 for temporary unavailability, 404 to indicate not-found responses,
	 * and 500 for all other invalid requests or responses
	 */
	public int status_code;

	/**
	 * status_txt will be a value that describes the nature of any error encountered. Common values are RATE_LIMIT_EXCEEDED, MISSING_ARG_%s to denote
	 * a missing URL parameter, and INVALID_%s to denote an invalid value in a request parameter (where %s is substituted with the name of the request
	 * parameter)
	 */
	public String status_txt;

	/** the actual response data */
	public T data;

}

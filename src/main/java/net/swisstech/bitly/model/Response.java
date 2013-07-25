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
public class Response<T> extends ResponsePartial {

	/** This flag will be set if there was a deserialization error */
	public boolean deserialize_error = false;

	/** the actual response data */
	public T data;
}

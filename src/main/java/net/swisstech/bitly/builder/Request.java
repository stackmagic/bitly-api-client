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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.swisstech.bitly.BitlyClientException;
import net.swisstech.bitly.gson.GsonFactory;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.ResponsePartial;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

/**
 * Base Request Builder and logic to make the actual call, add query parameters etc.
 *
 * @author Patrick Huber (gmail: stackmagic)
 *
 * @param <T> Type of the Response
 */
public abstract class Request<T> {

	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(Request.class.getName());

	/** GSON instance */
	private static final Gson GSON = GsonFactory.getGson();

	/** the access token to be used for the request */
	private final String accessToken;

	/** contains all query parameters to be added to the request */
	private List<QueryParameter> queryParameters = new LinkedList<QueryParameter>();

	/**
	 * Constructs a new Request
	 *
	 * TODO we could consider killing the constructor and instead add a setAccessToken method so the AT would be treated like every other query
	 * parameter.
	 *
	 * @param accessToken the access token to be used for the request
	 */
	public Request(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * Get the QueryParameters
	 * @return the QueryParameters
	 */
	public List<QueryParameter> getQueryParameters() {
		return Collections.unmodifiableList(queryParameters);
	}

	/**
	 * Subclasses must implement this method and return the endpoint like for example <code>http://example.com/api/resource</code>.
	 * @return the Endpoint
	 */
	public abstract String getEndpoint();

	/**
	 * GSON has this construct to deserialize generic types. Just using <code>Response&lt;T&gt;</code> won't work here for the same reasons GSON
	 * introduced this construct in the first place. So the RequestBuilder has to return an explicit type here, no T parameters or anything because
	 * that won't work and then GSON will serialize the responsee's data as a StringMap.
	 *
	 * @return Type for GSON deserializer
	 */
	protected abstract Type getTypeForGson();

	/**
	 * Add a QueryParameter
	 * @param name the Name of the Parameter
	 * @param value the Value of the Parameter
	 */
	public void addQueryParameter(String name, String value) {
		addQueryParameter(new QueryParameter(name, value));
	}

	/**
	 * Add a QueryParameter
	 * @param name the Name of the Parameter
	 * @param value the Value of the Parameter
	 */
	public void addQueryParameter(String name, boolean value) {
		addQueryParameter(new QueryParameter(name, value));
	}

	/**
	 * Add a QueryParameter
	 * @param name the Name of the Parameter
	 * @param value the Value of the Parameter
	 */
	public void addQueryParameter(String name, long value) {
		addQueryParameter(new QueryParameter(name, value));
	}

	/**
	 * Add a QueryParameter
	 * @param name the Name of the Parameter
	 * @param value the Value of the Parameter
	 */
	public void addQueryParameter(String name, DateTime value) {
		addQueryParameter(new QueryParameter(name, value.getMillis()));
	}

	/**
	 * Add a QueryParameter
	 * @param queryParameter the QueryParameter
	 */
	public void addQueryParameter(QueryParameter queryParameter) {
		queryParameters.add(queryParameter);
	}

	/**
	 * Build the URL for the call to the API.
	 * @return the URL
	 */
	public String buildUrl() {
		return buildUrl(queryParameters);
	}

	/**
	 * Build the URL for the call to the API. Subclasses can override this method if they need to add extra parameters or do some other special
	 * manipulations that this base implementation of URL builder doesn't provide.
	 * @param queryParameters the QueryParameters
	 * @return the URL
	 */
	protected String buildUrl(List<QueryParameter> queryParameters) {

		// TODO find a way to pass the collection to addQuery in a simple and
		// extensible way without breaking but extending the normal
		// addQueryParameter methods
		List<QueryParameter> params = new LinkedList<QueryParameter>(queryParameters);
		params.add(new QueryParameter("access_token", accessToken));

		StringBuffer url = new StringBuffer();
		url.append(getEndpoint());
		url.append("?");
		Iterator<QueryParameter> paramIter = params.iterator();
		while (paramIter.hasNext()) {
			String param = paramIter.next().toString();
			url.append(param);
			if (paramIter.hasNext()) {
				url.append("&");
			}
		}

		return url.toString();
	}

	/**
	 * Make the call to the API and return the result
	 * @return the Response
	 */
	public Response<T> call() {
		try {
			String url = buildUrl();
			LOG.debug("Calling URL: {}", url);
			URLConnection conn = new URL(url).openConnection();
			conn.connect();

			StringBuffer respBuf = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				respBuf.append(line);
			}

			String resp = respBuf.toString();
			LOG.trace("Response received: {}", resp);

			try {
				return deserializeFull(resp);
			}
			catch (JsonParseException e) {
				return deserializePartial(resp);
			}

		} catch (IOException e) {
			throw new BitlyClientException(e);
		}
	}

	/**
	 * Attempt to fully deserialize bitly's response
	 * @param resp bitly's response data
	 * @return the Response
	 */
	private Response<T> deserializeFull(String resp) {
		return GSON.fromJson(resp, getTypeForGson());
	}

	/**
	 * Only deserialize the status fields, copy them into a Response and set the <code>deserialize_error</code> flag.
	 * @param resp bitly's response data
	 * @return the Response
	 */
	private Response<T> deserializePartial(String resp) {
		ResponsePartial partial = GSON.fromJson(resp, ResponsePartial.class);
		Response<T> full = new Response<T>();
		full.data = null;
		full.deserialize_error = true;
		full.status_code = partial.status_code;
		full.status_txt = partial.status_txt;
		return full;
	}
}

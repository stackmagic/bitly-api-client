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
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.swisstech.bitly.gson.GsonFactory;
import net.swisstech.bitly.model.Response;

import org.joda.time.DateTime;

import com.google.gson.Gson;

public abstract class Request<T> {

	private final String accessToken;

	private List<QueryParameter> queryParameters = new LinkedList<QueryParameter>();

	public Request(String accessToken) {
		this.accessToken = accessToken;
	}

	public List<QueryParameter> getQueryParameters() {
		return Collections.unmodifiableList(queryParameters);
	}

	public abstract String getEndpoint();

	/**
	 * GSON has this construct to deserialize generic types. Just using
	 * <code>Response&lt;T&gt;</code> won't work here for the same reasons GSON
	 * introduced this construct in the first place. So the RequestBuilder has
	 * to return an explicit type here, no T parameters or anything because that
	 * won't work and then GSON will serialize the responsee's data as a
	 * StringMap.
	 * @return Type for GSON deserializer
	 */
	protected abstract Type getTypeForGson();

	public void addQueryParameter(String name, String value) {
		addQueryParameter(new QueryParameter(name, value));
	}

	public void addQueryParameter(String name, boolean value) {
		addQueryParameter(new QueryParameter(name, value));
	}

	public void addQueryParameter(String name, long value) {
		addQueryParameter(new QueryParameter(name, value));
	}

	public void addQueryParameter(String name, DateTime value) {
		addQueryParameter(new QueryParameter(name, value.getMillis()));
	}

	public void addQueryParameter(QueryParameter queryParameter) {
		queryParameters.add(queryParameter);
	}

	public String buildUrl() {
		return buildUrl(queryParameters);
	}

	protected String buildUrl(List<QueryParameter> params) {

		// TODO find a way to pass the collection to addQuery in a simple and
		// extensible way without breaking but extending the normal
		// addQueryParameter methods
		params = new LinkedList<QueryParameter>(params);
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

	public Response<T> call() {
		try {

			// make the call
			String url = buildUrl();
			System.out.println("Calling URL: " + url);
			URLConnection conn = new URL(url).openConnection();
			conn.connect();
			StringBuffer respBuf = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				respBuf.append(line);
			}
			String resp = respBuf.toString();

			// deserialize
			Gson gson = GsonFactory.getGson();
			Type type = getTypeForGson();
			Response<T> response = gson.fromJson(resp, type);
			return response;

		} catch (Throwable t) {
			// TODO cleanup
			throw new RuntimeException(t);
		}
	}
}

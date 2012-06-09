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
import java.util.LinkedList;
import java.util.List;

import net.swisstech.bitly.gson.converter.DateTimeTypeConverter;
import net.swisstech.bitly.gson.converter.InstantTypeConverter;
import net.swisstech.bitly.model.Response;

import org.joda.time.DateTime;
import org.joda.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class RequestBuilder<T> {

	private List<QueryParameter> queryParameters = new LinkedList<QueryParameter>();

	public RequestBuilder(String accessToken) {
		addQueryParameter("access_token", accessToken);
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

	public void addQueryParameter(QueryParameter queryParameter) {
		queryParameters.add(queryParameter);
	}

	public String buildUrl() {
		StringBuffer buf = new StringBuffer();
		buf.append(getEndpoint());
		buf.append("?");
		for (QueryParameter qp : queryParameters) {
			buf.append(qp);
			buf.append("&");
		}
		return buf.toString();
	}

	public Response<T> call() {
		try {

			// make the call
			URLConnection conn = new URL(buildUrl()).openConnection();
			conn.connect();
			StringBuffer respBuf = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				respBuf.append(line);
			}
			String resp = respBuf.toString();

			// get gson json impl
			GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(DateTime.class, new DateTimeTypeConverter());
			builder.registerTypeAdapter(Instant.class, new InstantTypeConverter());
			Gson gson = builder.create();

			// deserialize
			Response<T> response = gson.fromJson(resp, getTypeForGson());
			return response;

		} catch (Throwable t) {
			// TODO cleanup
			throw new RuntimeException(t);
		}
	}
}

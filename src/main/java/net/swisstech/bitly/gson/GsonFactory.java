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
package net.swisstech.bitly.gson;

import net.swisstech.bitly.gson.converter.DateTimeTypeConverter;
import net.swisstech.bitly.gson.converter.InstantTypeConverter;

import org.joda.time.DateTime;
import org.joda.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Factory for a Gson Instance, initialized with all converters used/needed. Only a single instance is created since Gson is thread-safe.
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public final class GsonFactory {

	private static final Gson GSON;

	/** private constructor for utility class */
	private GsonFactory() {
	}

	static {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(DateTime.class, new DateTimeTypeConverter());
		builder.registerTypeAdapter(Instant.class, new InstantTypeConverter());
		GSON = builder.create();
	}

	/**
	 * Get the Gson instance
	 * @return the Gson instance
	 */
	public static Gson getGson() {
		return GSON;
	}
}

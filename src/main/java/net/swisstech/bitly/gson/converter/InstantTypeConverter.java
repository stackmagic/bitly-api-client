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
package net.swisstech.bitly.gson.converter;

import java.lang.reflect.Type;

import org.joda.time.Instant;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Type Converter to serialize and deserialize Joda Time {@link Instant}
 * objects. Copied from the GSON Project Wiki/Manual.
 */
public class InstantTypeConverter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {

	@Override
	public JsonElement serialize(Instant src, Type srcType, JsonSerializationContext context) {
		return new JsonPrimitive(src.getMillis());
	}

	@Override
	public Instant deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
		return new Instant(json.getAsLong());
	}
}

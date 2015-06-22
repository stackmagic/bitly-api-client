package net.swisstech.bitly.gson.converter;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import net.swisstech.bitly.model.AbstractTag;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class AbstractTagConverter<T extends AbstractTag> implements JsonSerializer<T>, JsonDeserializer<T> {

	private final Class<T> clazz;

	public AbstractTagConverter(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
		List<String> list = Arrays.asList(src.key, src.value);
		return new JsonPrimitive(list.toString());
	}

	@Override
	public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			T tag = clazz.newInstance();
			JsonArray entry = json.getAsJsonArray();
			tag.key = entry.get(0).getAsString();
			tag.value = entry.get(1).getAsString();
			return tag;
		}
		catch (InstantiationException e) {
			return null;
		}
		catch (IllegalAccessException e) {
			return null;
		}
	}
}

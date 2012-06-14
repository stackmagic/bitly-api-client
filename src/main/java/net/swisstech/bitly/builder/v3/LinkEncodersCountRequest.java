package net.swisstech.bitly.builder.v3;

import java.lang.reflect.Type;

import net.swisstech.bitly.builder.RequestBuilder;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.LinkEncodersCount;

import com.google.gson.reflect.TypeToken;

public class LinkEncodersCountRequest extends RequestBuilder<LinkEncodersCount> {

	public LinkEncodersCountRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/link/encoders_count";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<Response<LinkEncodersCount>>() {
		}.getType();
	}

	public LinkEncodersCountRequest setLink(String link) {
		addQueryParameter("link", link);
		return this;
	}
}

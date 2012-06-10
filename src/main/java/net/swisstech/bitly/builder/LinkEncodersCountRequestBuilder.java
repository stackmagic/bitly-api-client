package net.swisstech.bitly.builder;

import java.lang.reflect.Type;

import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.LinkEncodersCount;

import com.google.gson.reflect.TypeToken;

public class LinkEncodersCountRequestBuilder extends RequestBuilder<LinkEncodersCount> {

	public LinkEncodersCountRequestBuilder(String accessToken) {
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

	public LinkEncodersCountRequestBuilder setLink(String link) {
		addQueryParameter("link", link);
		return this;
	}
}

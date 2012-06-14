package net.swisstech.bitly.builder.v3;

import java.lang.reflect.Type;

import net.swisstech.bitly.builder.Request;
import net.swisstech.bitly.model.ApiResponse;
import net.swisstech.bitly.model.v3.LinkEncodersCount;

import com.google.gson.reflect.TypeToken;

public class LinkEncodersCountRequest extends Request<LinkEncodersCount> {

	public LinkEncodersCountRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/link/encoders_count";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<ApiResponse<LinkEncodersCount>>() {
		}.getType();
	}

	public LinkEncodersCountRequest setLink(String link) {
		addQueryParameter("link", link);
		return this;
	}
}

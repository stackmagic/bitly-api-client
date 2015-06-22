package net.swisstech.bitly.builder.v3;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import net.swisstech.bitly.builder.Request;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.UserPopularLinksResponse;
import net.swisstech.bitly.model.v3.UserSaveCustomDomainKeywordResponse;

public class UserSaveCustomDomainKeywordRequest extends Request<UserSaveCustomDomainKeywordResponse>
{
    public UserSaveCustomDomainKeywordRequest(String accessToken)
    {
        super(accessToken);
    }

    public String getEndpoint()
    {
        return "https://api-ssl.bitly.com/v3/user/save_custom_domain_keyword";
    }

    protected Type getTypeForGson() {
    	
    	return new TypeToken<Response<UserSaveCustomDomainKeywordResponse>>() {
    		
    	}.getType();
    }

    public UserSaveCustomDomainKeywordRequest setKeyword_link(String keyword_link)
    {
        addQueryParameter("keyword_link", keyword_link);
        return this;
    }

    public UserSaveCustomDomainKeywordRequest setTarget_link(String target_link)
    {
        addQueryParameter("target_link", target_link);
        return this;
    }

    public UserSaveCustomDomainKeywordRequest setOverwrite(boolean overwrite)
    {
        addQueryParameter("overwrite", overwrite);
        return this;
    }
}

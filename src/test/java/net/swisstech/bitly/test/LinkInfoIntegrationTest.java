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
package net.swisstech.bitly.test;

import static net.swisstech.bitly.test.util.TestUtil.printAndVerify;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Type;

import net.swisstech.bitly.gson.GsonFactory;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.LinkInfoResponse;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/data_apis.html#v3_link_info">/v3/link/info</a> request.
 * </p>
 * @author Patrick Huber (gmail: stackmagic)
 */
public class LinkInfoIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callLinkInfo() throws IOException {
		Response<LinkInfoResponse> resp = getClient().linkInfo() //
			.setLink("http://bit.ly/MwSGaQ") //
			.call();

		printAndVerify(resp, LinkInfoResponse.class);

		assertTrue(resp.data.content_length > 0);
		assertNotNull(resp.data.category);
		assertNotNull(resp.data.domain);
		assertNotNull(resp.data.original_url);
		assertNotNull(resp.data.html_title);
		assertNotNull(resp.data.favicon_url);
		assertNotNull(resp.data.aggregate_link);
		assertNotNull(resp.data.content_type);
	}

	@Test
	public void deserializeLinkInfo() {
		Gson GSON = GsonFactory.getGson();
		String data = "{\"status_code\": 200, \"data\": {\"content_length\": 26790, \"category\": \"text\", \"domain\": \"blog.bitly.com\", \"original_url\": \"http://blog.bitly.com/post/26449494972/happy-independence-day-america\", \"html_title\": \"bitly blog - Happy Independence Day, America!\", \"linktags_other\": [ [\"key1\",\"value1\"],[\"key2\",\"value2\"]], \"metatags_name\": [ [\"key1\",\"value1\"],[\"key2\",\"value2\"]], \"favicon_url\": \"http://bitly.com/s/beta/graphics/vis/bitly-favicon-trans.png\", \"aggregate_link\": \"http://bit.ly/LNY08h\", \"content_type\": \"text/html; charset=utf-8\", \"indexed\": 1380097407, \"canonical_url\": \"http://blog.bitly.com/post/26449494972/happy-independence-day-america\"}, \"status_txt\": \"OK\"}";
		Type token = new TypeToken<Response<LinkInfoResponse>>() {}.getType();
		Response<LinkInfoResponse> resp = GSON.fromJson(data, token);
		assertNotNull(resp.data.metatags_name);
		assertTrue(resp.data.metatags_name.size() > 0);
		assertNotNull(resp.data.linktags_other);
		assertTrue(resp.data.linktags_other.size() > 0);
	}
}

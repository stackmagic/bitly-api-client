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
package net.swisstech.bitly.model.v3;

public class ShortUrl {

	public long new_hash;

	public String url;

	public String hash;

	public String global_hash;

	public String long_url;

	@Override
	public String toString() {
		return String.format("ShortUrl { new_hash=%d url=%s hash=%s global_hash=%s long_url=%s }", new_hash, url, hash, global_hash, long_url);
	}
}

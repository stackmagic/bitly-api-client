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

import java.util.List;

public class Expand {

	public List<Element> expand;

	public static class Element {

		public String short_url;

		public String hash;

		public String user_hash;

		public String global_hash;

		public String error;

		public String long_url;

		@Override
		public String toString() {
			return String.format("Element { short_url=%s hash=%s user_hash=%s global_hash=%s error=%s }", short_url, hash, user_hash, global_hash,
					error, long_url);
		}
	}

	@Override
	public String toString() {
		return String.format("Expand { expand=%s }", expand);
	}
}

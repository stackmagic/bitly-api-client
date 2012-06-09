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

public class LinkEdit {

	public Link link_edit;

	public static class Link {

		public String link;

		@Override
		public String toString() {
			return String.format("Link { link=%s }", link);
		}
	}

	@Override
	public String toString() {
		return String.format("LinkEdit { link_edit=%s }", link_edit);
	}
}

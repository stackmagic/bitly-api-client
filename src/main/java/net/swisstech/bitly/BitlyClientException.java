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
package net.swisstech.bitly;

/**
 * Simple RuntimeException. Thrown if something goes wrong.
 * @author Patrick Huber (gmail: stackmagic)
 */
public class BitlyClientException extends RuntimeException {

	private static final long serialVersionUID = 5810677972369016949L;

	/** Construct a new RequestBuilderException */
	public BitlyClientException() {
		super();
	}

	/**
	 * Construct a new RequestBuilderException
	 * @param message the Message
	 * @param cause the Cause
	 */
	public BitlyClientException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construct a new RequestBuilderException
	 * @param message the Message
	 */
	public BitlyClientException(String message) {
		super(message);
	}

	/**
	 * Construct a new RequestBuilderException
	 * @param cause the Cause
	 */
	public BitlyClientException(Throwable cause) {
		super(cause);
	}
}

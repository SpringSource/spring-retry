/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.retry.backoff;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Tomaz Fernandes
 * @since 1.3.2
 */
public class UniformRandomBackOffPolicyTest {

	@Test
	public void testSetSleeper() {
		UniformRandomBackOffPolicy backOffPolicy = new UniformRandomBackOffPolicy();
		int minBackOff = 1000;
		int maxBackOff = 10000;
		backOffPolicy.setMinBackOffPeriod(minBackOff);
		backOffPolicy.setMaxBackOffPeriod(maxBackOff);
		UniformRandomBackOffPolicy withSleeper = backOffPolicy.withSleeper(new DummySleeper());

		assertEquals(minBackOff, withSleeper.getMinBackOffPeriod());
		assertEquals(maxBackOff, withSleeper.getMaxBackOffPeriod());
	}

}

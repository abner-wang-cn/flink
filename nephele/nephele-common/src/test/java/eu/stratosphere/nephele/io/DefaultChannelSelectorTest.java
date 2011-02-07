/***********************************************************************************************************************
 *
 * Copyright (C) 2010 by the Stratosphere project (http://stratosphere.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 **********************************************************************************************************************/

package eu.stratosphere.nephele.io;

import junit.framework.Assert;

import org.junit.Test;

import eu.stratosphere.nephele.types.StringRecord;

/**
 * This class checks the functionality of the {@link DefaultChannelSelector} class.
 * 
 * @author marrus
 */
public class DefaultChannelSelectorTest {

	/**
	 * This test checks the channel selection
	 */
	@Test
	public void channelSelect() {

		StringRecord dummyRecord = new StringRecord("abc");
		DefaultChannelSelector<StringRecord> selector = new DefaultChannelSelector<StringRecord>();
		// Test with two channels
		boolean[] numberOfChannels = { false, false };
		selector.selectChannels(dummyRecord, numberOfChannels);
		Assert.assertEquals(true, numberOfChannels[1]);
		numberOfChannels[1] = false;
		selector.selectChannels(dummyRecord, numberOfChannels);
		Assert.assertEquals(true, numberOfChannels[0]);
		numberOfChannels[0] = false;
		selector.selectChannels(dummyRecord, numberOfChannels);
		Assert.assertEquals(true, numberOfChannels[1]);
		// Test with channel number 0
		boolean[] noChannels = {};
		selector.selectChannels(dummyRecord, noChannels);

	}

}

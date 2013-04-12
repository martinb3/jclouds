/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.ultradns.ws;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Map.Entry;

import org.jclouds.ultradns.ws.domain.Account;
import org.jclouds.ultradns.ws.domain.Region;
import org.jclouds.ultradns.ws.internal.BaseUltraDNSWSApiLiveTest;
import org.testng.annotations.Test;

/**
 * @author Adrian Cole
 */
@Test(groups = "live", singleThreaded = true, testName = "UltraDNSWSApiLiveTest")
public class UltraDNSWSApiLiveTest extends BaseUltraDNSWSApiLiveTest {

   @Test
   protected void testGetCurrentAccount() {
      Account account = api.getCurrentAccount();
      checkAccount(account);
   }

   private void checkAccount(Account account) {
      assertNotNull(account.getId(), "Id cannot be null for " + account);
      assertNotNull(account.getName(), "Name cannot be null for " + account);
   }

   @Test
   public void testListRegions() {
      for (Entry<Integer, Region> region : api.getRegionsById().entrySet()) {
         checkRegion(region);
      }
   }

   private void checkRegion(Entry<Integer, Region> region) {
      assertTrue(region.getKey() > 0, "Id cannot be negative " + region);
      assertNotNull(region.getValue().getName(), "Name cannot be null " + region);
      assertNotNull(region.getValue().getTerritoryNames(), "TerritoryNames cannot be null " + region);
      assertFalse(region.getValue().getTerritoryNames().isEmpty(), "TerritoryNames cannot be empty " + region);
   }
}
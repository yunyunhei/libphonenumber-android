/*
 * Copyright (C) 2012 The Libphonenumber Authors
 * Copyright (C) 2016 Michael Rozumyanskiy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.michaelrocks.libphonenumber.android;

import junit.framework.TestCase;

import io.michaelrocks.libphonenumber.android.nano.Phonemetadata.PhoneMetadata;

/**
 * Some basic tests to check that the phone number metadata can be correctly loaded.
 */
public class MetadataManagerTest extends TestCase {

  public void testAlternateFormatsContainsData() throws Exception {
    // We should have some data for Germany.
    PhoneMetadata germanyAlternateFormats = MetadataManager.getInstance().getAlternateFormatsForCountry(49);
    assertNotNull(germanyAlternateFormats);
    assertTrue(germanyAlternateFormats.numberFormat.length > 0);
  }

  public void testShortNumberMetadataContainsData() throws Exception {
    // We should have some data for France.
    PhoneMetadata franceShortNumberMetadata = MetadataManager.getInstance().getShortNumberMetadataForRegion("FR");
    assertNotNull(franceShortNumberMetadata);
    assertTrue(franceShortNumberMetadata.shortCode != null);
  }

  public void testAlternateFormatsFailsGracefully() throws Exception {
    PhoneMetadata noAlternateFormats = MetadataManager.getInstance().getAlternateFormatsForCountry(999);
    assertNull(noAlternateFormats);
  }

  public void testShortNumberMetadataFailsGracefully() throws Exception {
    PhoneMetadata noShortNumberMetadata = MetadataManager.getInstance().getShortNumberMetadataForRegion("XXX");
    assertNull(noShortNumberMetadata);
  }
}

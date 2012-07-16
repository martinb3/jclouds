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
package org.jclouds.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.FluentIterable;

/**
 * <pre>
 * PagedIterator<StorageMetadata> blobs = blobstore.list(...).iterator();
 * while (blobs.hasNext()) {
 *     FluentIterable<StorageMetadata> page = blobs.next();
 *     ProcessedResults results = process(page);
 *     if (results.shouldBeBookmarked() && blobs.nextMarker().isPresent()) {
 *         saveBookmark(blobs.nextMarker().get());
 *     }
 * }
 * </pre>
 * 
 * @author Adrian Cole
 */
@Beta
public abstract class PagedIterable<T> extends FluentIterable<IterableWithMarker<T>> {

   @Override
   public abstract PagedIterator<T> iterator();

}
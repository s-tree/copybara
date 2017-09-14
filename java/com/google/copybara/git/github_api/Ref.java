/*
 * Copyright (C) 2017 Google Inc.
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

package com.google.copybara.git.github_api;


import com.google.api.client.util.Key;
import com.google.common.base.MoreObjects;

/**
 * Represents the current status of a ref, as returned by the git/refs API call
 */
public class Ref {

  @Key private String ref;
  @Key private String url;
  @Key private Data object;

  /**
   * The internal data field.
   */
  public static class Data {
    @Key private String sha;
    @Key private String type;
    @Key private String url;
  }

  public String getRef() {
    return ref;
  }

  public String getUrl() {
    return url;
  }

  public String getSha() {
    return object.sha;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ref", ref)
        .add("url", url)
        .add("object.sha", object.sha)
        .add("object.type", object.type)
        .add("object.url", object.url)

        .toString();
  }
}

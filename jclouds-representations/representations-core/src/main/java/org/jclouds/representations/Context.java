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

package org.jclouds.representations;

import com.google.common.base.Objects;

import java.io.Serializable;

public class Context implements Serializable {

   private static final long serialVersionUID = -6490025246295140657L;

   public static Builder builder() {
      return new Builder();
   }

   public static class Builder {
      private String name;
      private String providerId;
      private String identity;

      public Builder name(final String name) {
         this.name = name;
         return this;
      }

      public Builder providerId(final String providerId) {
         this.providerId = providerId;
         return this;
      }

      public Builder identity(final String identity) {
         this.identity = identity;
         return this;
      }

      public Context build() {
         return new Context(name, providerId, identity);
      }
   }

   private final String name;
   private final String providerId;
   private final String identity;


   public Context(String name, String providerId, String identity) {
      this.name = name;
      this.providerId = providerId;
      this.identity = identity;
   }

   public String getName() {
      return name;
   }

   public String getProviderId() {
      return providerId;
   }

   public String getIdentity() {
      return identity;
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(name);
   }

   @Override
   public boolean equals(Object that) {
      if (that == null)
         return false;
      return Objects.equal(this.toString(), that.toString());
   }

   @Override
   public String toString() {
      return Objects.toStringHelper(this).add("name", name).add("providerId", providerId).add("identity", identity).toString();
   }
}

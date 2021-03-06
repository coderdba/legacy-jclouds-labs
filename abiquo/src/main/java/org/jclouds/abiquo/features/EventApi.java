/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jclouds.abiquo.features;

import java.io.Closeable;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jclouds.abiquo.domain.event.options.EventOptions;
import org.jclouds.abiquo.http.filters.AbiquoAuthentication;
import org.jclouds.abiquo.http.filters.AppendApiVersionToMediaType;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.RequestFilters;

import com.abiquo.server.core.event.EventsDto;

/**
 * Provides synchronous access to Abiquo Event API.
 * 
 * @see API: <a href="http://community.abiquo.com/display/ABI20/API+Reference">
 *      http://community.abiquo.com/display/ABI20/API+Reference</a>
 * @author Ignasi Barrera
 * @author Vivien Mahé
 */
@RequestFilters({ AbiquoAuthentication.class, AppendApiVersionToMediaType.class })
@Path("/events")
public interface EventApi extends Closeable {
   /**
    * List events.
    * 
    * @return The list of events.
    */
   @Named("event:list")
   @GET
   @Consumes(EventsDto.BASE_MEDIA_TYPE)
   @JAXBResponseParser
   EventsDto listEvents();

   /**
    * List events using filters.
    * 
    * @return The list of events using filters.
    */
   @Named("event:list")
   @GET
   @Consumes(EventsDto.BASE_MEDIA_TYPE)
   @JAXBResponseParser
   EventsDto listEvents(EventOptions options);
}

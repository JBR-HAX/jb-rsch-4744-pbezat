/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.locations;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class LocationsDBSaver
{
    private final LocationRepository locationRepository;
    private static final Gson GSON = new Gson();

    void save(List<LocationsRequest> locationsRequests, List<LocationsResponse> locationsResponses)
    {
        String jsonRequests = GSON.toJson(locationsRequests);
        String jsonResponses = GSON.toJson(locationsResponses);

        LocationEntity entity = new LocationEntity();
        entity.setLocationsRequest(jsonRequests);
        entity.setLocationsResponses(jsonResponses);

        locationRepository.save(entity);
    }
}

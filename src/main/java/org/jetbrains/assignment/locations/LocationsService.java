/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.locations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class LocationsService
{
    private PositionsCalculator positionsCalculator;
    private LocationsDBSaver dbSaver;

    List<LocationsResponse> handleLocations(List<LocationsRequest> locations)
    {
        List<LocationsResponse> locationsResponses = positionsCalculator.calculatePositions(locations);

        dbSaver.save(locations, locationsResponses);
        return locationsResponses;
    }
}

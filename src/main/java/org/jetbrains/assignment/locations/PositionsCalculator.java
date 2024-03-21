/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.locations;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class PositionsCalculator
{
    List<LocationsResponse> calculatePositions(List<LocationsRequest> locations)
    {
        // Initial positions
        int x = 0;
        int y = 0;
        List<LocationsResponse> results = new ArrayList<>();

        // Add initial position
        results.add(new LocationsResponse(x, y));

        // Iterate over steps
        for (LocationsRequest location : locations)
        {
            switch (location.getDirection())
            {
                case NORTH:
                    y += location.getSteps();
                    break;
                case EAST:
                    x += location.getSteps();
                    break;
                case SOUTH:
                    y -= location.getSteps();
                    break;
                case WEST:
                    x -= location.getSteps();
                    break;
            }

            results.add(new LocationsResponse(x, y));
        }

        return results;
    }
}

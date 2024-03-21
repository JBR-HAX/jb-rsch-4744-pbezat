package org.jetbrains.assignment.locations;

import org.jetbrains.assignment.locations.LocationsRequest;
import org.jetbrains.assignment.locations.LocationsResponse;
import org.jetbrains.assignment.locations.PositionsCalculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.jetbrains.assignment.common.Direction.EAST;
import static org.jetbrains.assignment.common.Direction.NORTH;
import static org.jetbrains.assignment.common.Direction.SOUTH;
import static org.jetbrains.assignment.common.Direction.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionsCalculatorTest
{
    @Test
    void calculatePositions_basicScenario()
    {
        // arrange
        List<LocationsRequest> locationsRequests = Arrays.asList(
            new LocationsRequest(EAST, 1),
            new LocationsRequest(NORTH, 3),
            new LocationsRequest(EAST, 3),
            new LocationsRequest(SOUTH, 5),
            new LocationsRequest(WEST, 2)
        );

        PositionsCalculator positionsCalculator = new PositionsCalculator();

        // act
        List<LocationsResponse> locationsResponses = positionsCalculator.calculatePositions(locationsRequests);

        // assert
        assertEquals(locationsResponses.size(), 6);
        LocationsResponse locationsResponse1 = locationsResponses.get(0);
        assertEquals(locationsResponse1.getX(), 0);
        assertEquals(locationsResponse1.getY(), 0);

        LocationsResponse locationsResponse2 = locationsResponses.get(1);
        assertEquals(locationsResponse2.getX(), 1);
        assertEquals(locationsResponse2.getY(), 0);

        LocationsResponse locationsResponse3 = locationsResponses.get(2);
        assertEquals(locationsResponse3.getX(), 1);
        assertEquals(locationsResponse3.getY(), 3);

        LocationsResponse locationsResponse4 = locationsResponses.get(3);
        assertEquals(locationsResponse4.getX(), 4);
        assertEquals(locationsResponse4.getY(), 3);

        LocationsResponse locationsResponse5 = locationsResponses.get(4);
        assertEquals(locationsResponse5.getX(), 4);
        assertEquals(locationsResponse5.getY(), -2);

        LocationsResponse locationsResponse6 = locationsResponses.get(5);
        assertEquals(locationsResponse6.getX(), 2);
        assertEquals(locationsResponse6.getY(), -2);
    }
}
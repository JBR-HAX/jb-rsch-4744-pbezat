package org.jetbrains.assignment.moves;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.jetbrains.assignment.common.Direction.EAST;
import static org.jetbrains.assignment.common.Direction.NORTH;
import static org.jetbrains.assignment.common.Direction.SOUTH;
import static org.jetbrains.assignment.common.Direction.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovesCalculatorTest
{

    @Test
    void calculateMoves()
    {
        // arrange
        List<MovesRequest> movesRequests = Arrays.asList(
            new MovesRequest(0, 0),
            new MovesRequest(1, 0),
            new MovesRequest(1, 3),
            new MovesRequest(0, 3),
            new MovesRequest(0, 0)
        );

        MovesCalculator movesCalculator = new MovesCalculator();

        // act
        List<MovesResponse> responses = movesCalculator.calculateMoves(movesRequests);
        assertEquals(responses.size(), 4);

        MovesResponse movesResponse1 = responses.get(0);
        assertEquals(movesResponse1.getDirection(), EAST);
        assertEquals(movesResponse1.getSteps(), 1);

        MovesResponse movesResponse2 = responses.get(1);
        assertEquals(movesResponse2.getDirection(), NORTH);
        assertEquals(movesResponse2.getSteps(), 3);

        MovesResponse movesResponse3 = responses.get(2);
        assertEquals(movesResponse3.getDirection(), WEST);
        assertEquals(movesResponse3.getSteps(), 1);

        MovesResponse movesResponse4 = responses.get(3);
        assertEquals(movesResponse4.getDirection(), SOUTH);
        assertEquals(movesResponse4.getSteps(), 3);
    }
}
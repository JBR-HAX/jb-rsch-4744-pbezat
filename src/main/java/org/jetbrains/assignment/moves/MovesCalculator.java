/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.moves;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.jetbrains.assignment.common.Direction.EAST;
import static org.jetbrains.assignment.common.Direction.NORTH;
import static org.jetbrains.assignment.common.Direction.SOUTH;
import static org.jetbrains.assignment.common.Direction.WEST;

@Component
class MovesCalculator
{
    List<MovesResponse> calculateMoves(List<MovesRequest> moves)
    {
        List<MovesResponse> responses = new ArrayList<>();

        MovesRequest previousLocation = moves.get(0);

        for (int i = 1; i < moves.size(); i++)
        {
            MovesRequest move = moves.get(i);
            int xMove = move.getX() - previousLocation.getX();
            int yMove = move.getY() - previousLocation.getY();

            if (xMove != 0)
            {
                responses.add(new MovesResponse(xMove > 0 ? EAST : WEST, Math.abs(xMove)));
            }

            if (yMove != 0)
            {
                responses.add(new MovesResponse(yMove > 0 ? NORTH : SOUTH, Math.abs(yMove)));
            }

            previousLocation = move;
        }

        return responses;
    }
}

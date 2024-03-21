/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.moves;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class MovesService
{
    private final MovesCalculator movesCalculator;
    private final MovesDBSaver movesDBSaver;

    List<MovesResponse> handleMoves(List<MovesRequest> moves)
    {
        List<MovesResponse> movesResponses = movesCalculator.calculateMoves(moves);

        movesDBSaver.save(moves, movesResponses);
        return movesResponses;
    }
}

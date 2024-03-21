/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.moves;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
class MovesController
{
    private final MovesService movesService;

    @PostMapping(value = "/moves", consumes = "application/json", produces = "application/json")
    public @ResponseBody List<MovesResponse> handleMoves(@RequestBody List<MovesRequest> moves)
    {
        return movesService.handleMoves(moves);
    }
}

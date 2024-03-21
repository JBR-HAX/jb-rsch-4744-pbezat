/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.moves;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class MovesDBSaver
{
    private final MovesRepository movesRepository;
    private static final Gson GSON = new Gson();

    void save(List<MovesRequest> locationsRequests, List<MovesResponse> locationsResponses)
    {
        String jsonRequests = GSON.toJson(locationsRequests);
        String jsonResponses = GSON.toJson(locationsResponses);

        MovesEntity entity = new MovesEntity();
        entity.setMovesRequest(jsonRequests);
        entity.setMovesResponses(jsonResponses);

        movesRepository.save(entity);
    }
}

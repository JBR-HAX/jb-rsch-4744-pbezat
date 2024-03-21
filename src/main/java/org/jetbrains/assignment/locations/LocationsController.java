/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.locations;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
class LocationsController
{
    private final LocationsService locationsService;

    @PostMapping(value = "/locations", consumes = "application/json", produces = "application/json")
    public @ResponseBody List<LocationsResponse> handleLocations(@RequestBody List<LocationsRequest> locations)
    {
        return locationsService.handleLocations(locations);
    }
}

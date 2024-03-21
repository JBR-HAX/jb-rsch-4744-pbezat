/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.assignment.common.Direction;

@Data
@AllArgsConstructor
class LocationsRequest
{
    private Direction direction;
    private int steps;
}

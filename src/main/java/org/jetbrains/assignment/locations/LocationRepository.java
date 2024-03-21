/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.locations;

import org.springframework.data.jpa.repository.JpaRepository;

interface LocationRepository extends JpaRepository<LocationEntity, Long>
{
}

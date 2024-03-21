/********************************************
 *
 * Copyright (c) 2003-2024 XML-INTL Ltd.
 *
 * All Rights Reserved
 *
 ********************************************/
package org.jetbrains.assignment.moves;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
class MovesEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String movesRequest;

    @Column
    private String movesResponses;
}

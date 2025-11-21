package org.ort.starwars.fleet.infrastructure.persistence.entities;

import org.ort.starwars.fleet.dormain.models.enums.Breed;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Caractétistiques
    @Enumerated(EnumType.STRING)
    private final Breed breed;

    // Personnel disponible
    @Column
    private int recruits;
}

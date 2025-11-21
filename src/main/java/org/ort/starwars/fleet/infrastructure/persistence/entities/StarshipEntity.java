package org.ort.starwars.fleet.infrastructure.persistence.entities;
import org.ort.starwars.fleet.dormain.models.enums.StarshipType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Caractéristiques
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private StarshipType category;
    @Column
    private int length;
    @Column
    private int crew;
    @Column
    private int passengers;
    @Column
    private String pilot;
}

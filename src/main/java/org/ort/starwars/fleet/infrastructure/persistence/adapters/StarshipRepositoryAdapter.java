package org.ort.starwars.fleet.infrastructure.persistence.adapters;

import java.util.List;

import org.ort.starwars.fleet.application.ports.StarshipRepositoryPort;
import org.ort.starwars.fleet.dormain.models.entities.Starship;
import org.ort.starwars.fleet.infrastructure.persistence.mappers.StarshipMapper;
import org.ort.starwars.fleet.infrastructure.persistence.repositories.StarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StarshipRepositoryAdapter implements StarshipRepositoryPort {
    @Autowired
    StarshipRepository repository;
    StarshipMapper starshipMapper;
    public  List<Starship> findAll(){
        var entities = repository.findAll();
        var irl = starshipMapper.toDomain(entities);
        return irl;
    }
}

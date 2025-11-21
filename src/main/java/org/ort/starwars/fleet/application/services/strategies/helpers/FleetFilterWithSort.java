
package org.ort.starwars.fleet.application.services.strategies.helpers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.ort.starwars.fleet.dormain.models.entities.Starship;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class FleetFilterWithSort extends FleetFilter {
    private final Comparator<Starship> comparator;

    public List<Starship> apply(List<Starship> range) {
        List<Starship> sorted = new ArrayList<>();
        sorted.addAll(range);
        sorted.sort(comparator);
        return super.apply(sorted);
    }
}

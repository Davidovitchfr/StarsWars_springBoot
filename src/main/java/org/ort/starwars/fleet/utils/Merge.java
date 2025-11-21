package org.ort.starwars.fleet.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Merge<K, V> {
    private final Function<V, K> keyExtractor;
    private final Map<K, V> before = new HashMap<>();
    private final Map<K, V> after = new HashMap<>();
    private final List<V> saved = new ArrayList<>();

    public Merge(Iterable<V> existing, Function<V, K> keyExtractor) {
        this.keyExtractor = keyExtractor;
        existing.forEach(item -> {
            K key = keyExtractor.apply(item);
            this.before.put(key, item);
        });
    }

    /**
     * Ajoute un élément
     * Si cet élément existe déjà, l'élément déjà présent est mis à jour
     * Si cet élément n'existe pas, il est ajouté tel quel
     */
    public void add(V item, BiConsumer<V, V> merge) {
        K key = keyExtractor.apply(item);
        if (before.containsKey(key)) {
            merge.accept(item, before.get(key));
        }
        saved.add(item);
    }

    public void addAll(Iterable<V> items, BiConsumer<V, V> merge) {
        for (V item : items) {
            add(item, merge);
        }
    }

    public List<V> getSaved() {
        return saved;
    }

    public List<V> getDeleted() {
        return before.entrySet().stream()
                .filter(kvp -> !after.containsKey(kvp.getKey()))
                .map(kvp -> kvp.getValue())
                .toList();
    }
}

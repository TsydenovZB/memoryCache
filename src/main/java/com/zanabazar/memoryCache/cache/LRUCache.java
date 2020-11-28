package com.zanabazar.memoryCache.cache;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<V> implements Cache<V> {

    LinkedHashMap<Integer, V> map = new LinkedHashMap<>();
    int count = 0;
    int size;

    public LRUCache(final int SIZE) {
        this.size = SIZE;
    }

    @Override
    public V get(Integer id) {
        V value = null;
        if (map.containsKey(id)) {
            value = map.get(id);
            map.remove(id);
            map.put(id, value);
        }
        return value;
    }

    @Override
    public void add(V value) {
        if (map.size() >= size) {
            Integer currentKey = map.keySet().iterator().next();
            map.remove(currentKey);
        }
        map.put(++count, value);
    }

    @Override
    public void remove(Integer key) {
        map.remove(key);
    }

    @Override
    public Map<Integer, V> model() {
        return new LinkedHashMap<>(map);
    }

    @Override
    public Collection<V> showAll() {
        return map.values();
    }
}

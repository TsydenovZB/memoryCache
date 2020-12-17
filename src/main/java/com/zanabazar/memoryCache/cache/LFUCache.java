package com.zanabazar.memoryCache.cache;

import java.util.*;

public class LFUCache<K, V> implements Cache<K, V> {

    LinkedHashMap<K, V> map = new LinkedHashMap<>();
    HashMap<K, Integer> frequency = new HashMap<>();
    int size;

    public LFUCache(int size) {
        this.size = size;
    }

    @Override
    public V get(K key) {
        frequency.put(key, frequency.get(key)+1);
        return map.get(key);
    }

    @Override
    public void add(K key, V value) {
        if (map.size() >= size) {
            K entryKeyToBeRemoved = getLFUKey();
            map.remove(entryKeyToBeRemoved);
        }
        map.put(key, value);
        frequency.put(key, 0);
    }

    private K getLFUKey() {
        K key = null;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (minFreq > frequency.get(entry.getKey())) {
                key = entry.getKey();
                minFreq = frequency.get(entry.getKey());
            }
        }
        return key;
    }
    @Override
    public void remove(K key) {
        frequency.remove(key);
        map.remove(key);
    }

    @Override
    public Map<K, V> model() {
        return new LinkedHashMap<>(map);
    }

    @Override
    public Map<K, V> showAll() {
        return map;
    }
}

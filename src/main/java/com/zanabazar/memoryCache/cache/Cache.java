package com.zanabazar.memoryCache.cache;

import java.util.Map;

public interface Cache<K, V> {

    V get(K key);

    void add(K k, V v);

    void remove(K key);

    Map<K, V> showAll();

    Map<K, V> model();
}

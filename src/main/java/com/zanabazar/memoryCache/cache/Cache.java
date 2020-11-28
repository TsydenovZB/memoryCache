package com.zanabazar.memoryCache.cache;

import java.util.Collection;
import java.util.Map;

public interface Cache<V> {

    public V get (Integer id);

    public void add(V v);

    public void remove(Integer id);

    public Map<Integer, V> model();

    public Collection<V> showAll();
}

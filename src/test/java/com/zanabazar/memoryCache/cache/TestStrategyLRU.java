package com.zanabazar.memoryCache.cache;

import org.junit.Test;

import java.util.NoSuchElementException;


public class TestStrategyLRU extends TestStrategy {

    @Test
    public void test() {
        Cache<Object> cache = new LRUCache<>(5);

        cache.add(person1);
        cache.add(person2);
        cache.add(person3);
        TestStrategy.assertModel(cache, person1, person2, person3);
        cache.add(person4);
        cache.add(person5);
        cache.get(1);
        cache.add(person6);
        TestStrategy.assertModel(cache, person3, person4, person5, person1, person6);
        cache.add(person7);
        cache.add(person8);
        TestStrategy.assertModel(cache, person5, person1, person6, person7, person8);
        cache.get(5);
        cache.add(person9);
        cache.add(person10);
        TestStrategy.assertModel(cache, person7, person8, person5, person9, person10);
    }

    @Test
    public void testWithZeroSize () {
        Cache<Object> cache = new LRUCache<>(0);
        try {
            cache.add("A");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWithAddNull () {
        Cache<Object> cache = new LRUCache<>(5);
        cache.add(null);
        cache.showAll();
    }

    @Test
    public void testSingleton () {
        Cache<Object> cache = new LRUCache<>(1);
        cache.add("A");
        cache.add("B");
        TestStrategy.assertModel(cache, "B");
    }

    @Test
    public void removeOneItem() {
        Cache<Object> cache = new LRUCache<>(2);
        cache.add("A");
        cache.add("B");
        cache.remove(2);
        TestStrategy.assertModel(cache, "A");
    }
}

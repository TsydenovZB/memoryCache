package com.zanabazar.memoryCache.cache;

import org.junit.Test;

import java.util.NoSuchElementException;


public class TestStrategyLRU extends TestStrategy {

    @Test
    public void test() {
        Cache<Integer, Object> cache = new LRUCache<>(5);

        cache.add(1, person1);
        cache.add(2, person2);
        cache.add(3, person3);
        TestStrategy.assertModel(cache, person1, person2, person3);
        cache.add(4,person4);
        cache.add(5,person5);
        cache.get(1);
        cache.add(6,person6);
        TestStrategy.assertModel(cache, person3, person4, person5, person1, person6);
        cache.add(7, person7);
        cache.add(8, person8);
        TestStrategy.assertModel(cache, person5, person1, person6, person7, person8);
        cache.get(5);
        cache.add(9,person9);
        cache.add(10,person10);
        TestStrategy.assertModel(cache, person7, person8, person5, person9, person10);
    }

    @Test
    public void testWithZeroSize () {
        Cache<Integer, Object> cache = new LRUCache<>(0);
        try {
            cache.add(1,"A");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWithAddNull () {
        Cache<Integer, Object> cache = new LRUCache<>(5);
        try {
            cache.add(1, null);
            cache.showAll();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSingleton () {
        Cache<Integer, Object> cache = new LRUCache<>(1);
        cache.add(1, "A");
        cache.add(2, "B");
        TestStrategy.assertModel(cache, "B");
    }

    @Test
    public void removeOneItem() {
        Cache<Integer, Object> cache = new LRUCache<>(2);
        cache.add(1, "A");
        cache.add(2, "B");
        cache.remove(2);
        TestStrategy.assertModel(cache, "A");
    }
}

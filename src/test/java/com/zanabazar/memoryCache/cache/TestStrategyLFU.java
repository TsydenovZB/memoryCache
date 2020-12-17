package com.zanabazar.memoryCache.cache;

import org.junit.Test;

import java.util.NoSuchElementException;

public class TestStrategyLFU extends TestStrategy {

    @Test
    public void test() {
        //[personName:frequency]
        Cache<Integer, Object> cache = new LFUCache<>(5);

        cache.add(1, person1);
        cache.get(1);
        cache.get(1);
        cache.add(2, person2);
        //[person1 : 2, person2 : 0]
        TestStrategy.assertModel(cache, person1, person2);
        cache.add(3, person3);
        cache.get(3);
        cache.add(4, person4);
        cache.get(4);
        cache.add(5, person5);
        //[person1 : 2, person2 : 0, person3 : 1, person4 : 1, person5 : 0]
        TestStrategy.assertModel(cache, person1, person2, person3, person4, person5);
        cache.get(5);
        cache.add(6, person6);
        //[person1 : 2, person3 : 1, person4 : 1, person5 : 1, person6 : 0]
        TestStrategy.assertModel(cache, person1, person3, person4, person5, person6);
        cache.add(7, person7);
        cache.get(7);
        cache.get(7);
        cache.add(8, person8);
        //[person1 : 2, person4 : 1, person5 : 1, person7 : 2, person8 : 0]
        TestStrategy.assertModel(cache, person1, person4, person5, person7, person8);
        cache.get(8);
        cache.add(9, person9);
        cache.add(10, person10);
        //[person1 : 2, person5 : 1, person7 : 2, person8 : 1, person10 : 0]
        TestStrategy.assertModel(cache, person1, person5, person7, person8, person10);
    }

    @Test
    public void testWithZeroSize () {
        Cache<Integer, Object> cache = new LRUCache<>(0);
        try {
            cache.add(1, "A");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWithAddNull () {
        Cache<Integer, Object> cache = new LRUCache<>(5);
        cache.add(1, null);
        cache.showAll();
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
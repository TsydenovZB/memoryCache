package com.zanabazar.memoryCache.cache;

import org.junit.Test;

import java.util.NoSuchElementException;

public class TestStrategyLFU extends TestStrategy {

    @Test
    public void test() {
        //[personName:frequency]
        Cache<Object> cache = new LFUCache<>(5);

        cache.add(person1);
        cache.get(1);
        cache.get(1);
        cache.add(person2);
        //[person1 : 2, person2 : 0]
        TestStrategy.assertModel(cache, person1, person2);
        cache.add(person3);
        cache.get(3);
        cache.add(person4);
        cache.get(4);
        cache.add(person5);
        //[person1 : 2, person2 : 0, person3 : 1, person4 : 1, person5 : 0]
        TestStrategy.assertModel(cache, person1, person2, person3, person4, person5);
        cache.get(5);
        cache.add(person6);
        //[person1 : 2, person3 : 1, person4 : 1, person5 : 1, person6 : 0]
        TestStrategy.assertModel(cache, person1, person3, person4, person5, person6);
        cache.add(person7);
        cache.get(7);
        cache.get(7);
        cache.add(person8);
        //[person1 : 2, person4 : 1, person5 : 1, person7 : 2, person8 : 0]
        TestStrategy.assertModel(cache, person1, person4, person5, person7, person8);
        cache.get(8);
        cache.add(person9);
        cache.add(person10);
        //[person1 : 2, person5 : 1, person7 : 2, person8 : 1, person10 : 0]
        TestStrategy.assertModel(cache, person1, person5, person7, person8, person10);
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
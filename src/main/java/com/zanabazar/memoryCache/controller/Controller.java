package com.zanabazar.memoryCache.controller;

import com.zanabazar.memoryCache.Application;
import com.zanabazar.memoryCache.cache.Cache;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class Controller {
    Cache<Object, Object> cache = Application.cache;

    @GetMapping("{id}")
    public Object get(@PathVariable("id") Integer id) {
        return cache.get(id);
    }

    @GetMapping
    public Map<Object, Object> getAll() {
        return cache.showAll();
    }

    @PostMapping
    public Map<Object, Object> add(@RequestBody Map<Object, Object> map) {
        cache.add(map.get("key"), map.get("value"));
        return cache.showAll();
    }

    @DeleteMapping("{id}")
    public Map<Object, Object> delete(@PathVariable("id") Integer id) {
        cache.remove(id);
        return cache.showAll();
    }
}

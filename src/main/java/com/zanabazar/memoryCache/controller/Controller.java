package com.zanabazar.memoryCache.controller;

import com.zanabazar.memoryCache.Application;
import com.zanabazar.memoryCache.cache.Cache;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping
public class Controller {
    Cache<Object> cache = Application.cache;

    @GetMapping("{id}")
    public Object get(@PathVariable("id") Integer id) {
        return cache.get(id);
    }

    @GetMapping
    public Collection<Object> getAll() {
        return cache.showAll();
    }

    @PostMapping
    public Collection<Object> add(@RequestBody Object o) {
        cache.add(o);
        return cache.showAll();
    }

    @DeleteMapping("{id}")
    public Collection<Object> delete(@PathVariable("id") Integer id) {
        cache.remove(id);
        return cache.showAll();
    }
}

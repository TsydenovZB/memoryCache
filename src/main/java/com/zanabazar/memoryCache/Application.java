package com.zanabazar.memoryCache;

import com.zanabazar.memoryCache.cache.Cache;
import com.zanabazar.memoryCache.cache.LFUCache;
import com.zanabazar.memoryCache.cache.LRUCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static Cache<Object> cache;
    public static Integer size;

    public static void main(String[] args) {
        size = Integer.valueOf(args[0]);
        cache = args[1].equals("LFU") ? new LFUCache<>(size) : new LRUCache<>(size);

        SpringApplication.run(Application.class, args);
    }
}

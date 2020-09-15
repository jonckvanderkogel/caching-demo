package com.example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheableService {
    @Cacheable(value = "entityCount")
    public int someEntityCount(final String criteria) {
        System.out.print(String.format("Inside function: %s", criteria));
        return 5;
    }
}
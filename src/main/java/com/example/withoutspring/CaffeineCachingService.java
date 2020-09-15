package com.example.withoutspring;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

public class CaffeineCachingService {
    private LoadingCache<String, Integer> entityCountCache = Caffeine.newBuilder()
            .expireAfterAccess(5, TimeUnit.MINUTES)
            .build(key -> someEntityCount(key));

    public int cachedEntityCount(final String criteria) {
        return entityCountCache.get(criteria);
    }

    private int someEntityCount(final String criteria) {
        System.out.print(String.format("Inside function: %s", criteria));
        return 5;
    }
}

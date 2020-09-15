package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    private CacheableService cacheableService;

    public A(@Autowired CacheableService cacheableService) {
        this.cacheableService = cacheableService;
    }

    public int getEntityCount(String criteria) {
        return cacheableService.someEntityCount(criteria);
    }
}
package com.example.withoutspring;

public class B {
    private CaffeineCachingService cacheableService;

    public B() {
        cacheableService = new CaffeineCachingService();
    }

    public int getEntityCount(String criteria) {
        return cacheableService.cachedEntityCount(criteria);
    }
}

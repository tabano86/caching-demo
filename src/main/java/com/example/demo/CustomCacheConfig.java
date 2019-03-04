package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomCacheConfig {
    @Autowired
    private CacheManager cacheManager;

    @Scheduled(fixedRateString = "30000") // refresh every x milliseconds
    public void clearCacheSchedule() {
        cacheManager.getCache("numbersList").clear();
    }
}
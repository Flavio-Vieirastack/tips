package com.initbinder.initBinder.Service;

import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

    public void init() {
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

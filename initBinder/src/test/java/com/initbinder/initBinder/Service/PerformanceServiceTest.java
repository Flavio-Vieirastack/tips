package com.initbinder.initBinder.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PerformanceServiceTest {

    @Autowired
    private PerformanceService performanceService;

    @Test
    public void performanceTest() {
        Long start = System.currentTimeMillis();

        for (int i = 0; i < 50; i++) {
            performanceService.init();
        }
        Long end = System.currentTimeMillis();
        Long totalTime = end - start;
        System.out.println("Tempo total para 1000 operações: " + totalTime + "ms");
        assertThat(totalTime).isLessThan(6000);
    }

}
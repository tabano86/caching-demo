package com.example.demo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DemoService {
    @Cacheable(value = "numberList")
    public List<Integer> baseCall() {
        double sleepTime = 3; // sec
        for (int i = 1; i <= sleepTime*2; i++) {
            try {
                Thread.sleep(i * 500);
                System.out.printf("Simulated Response Time: %.2f%%%n", (100 * i / (2 * sleepTime)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return IntStream.range(0, 100).boxed().collect(Collectors.toList());
    }
}

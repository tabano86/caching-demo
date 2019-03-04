package com.example.demo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class DemoService {
    @Cacheable(value = "numbersList", key = "#make.concat('-').concat(#model)")
    public List<Integer> baseCall(String make, String model) {
        this.slowItDown(2);
        return new Random().ints(100).boxed().collect(Collectors.toList());
    }

    private void slowItDown(double sleepTime) {
        for (int i = 1; i <= sleepTime; i++) {
            try {
                Thread.sleep(i * 1000);
                System.out.printf("Simulated Response Time: %.0f%%%n", (100 * i / sleepTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

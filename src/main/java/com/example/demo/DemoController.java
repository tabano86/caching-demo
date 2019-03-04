package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    // below will not work! Must be autowired!

    /*
    @Cacheable(value = "numberList")
    private List<Integer> baseCall() {
        double sleepTime = 3; // sec
        for (int i = 1; i <= sleepTime * 2; i++) {
            try {
                Thread.sleep(i * 500);
                System.out.printf("Simulated Response Time: %f%%", (100 * i / (2 * sleepTime)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return IntStream.range(0, 100).boxed().collect(Collectors.toList());
    }*/

    @GetMapping("/getData")
    public List<Integer> getData() {
        return this.demoService.baseCall();
    }

}

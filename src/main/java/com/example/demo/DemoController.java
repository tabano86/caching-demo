package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/getData/{make}/{model}")
    public List<Integer> getData(@PathVariable String make, @PathVariable String model) {
        return this.demoService.baseCall(make, model);
    }

}

package com.group.libraryapp.controller.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/add") // GET /add
    public int addTwoNumbers(@RequestParam int num1, @RequestParam int num2) {
        return num1 + num2;
    }
}

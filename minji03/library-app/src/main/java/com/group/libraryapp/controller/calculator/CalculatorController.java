package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/add") // GET /add
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNum1() + request.getNum2();
    }
}

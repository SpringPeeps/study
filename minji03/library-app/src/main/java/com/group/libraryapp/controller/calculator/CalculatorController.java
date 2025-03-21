package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorCalcResponse;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorSumResponse;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController {
    @GetMapping("/add") // GET /add
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNum1() + request.getNum2();
    }
    @PostMapping("/multiply") // POST /multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNum1() * request.getNum2();
    }
    // 추가 예제 -> 문제 1: 입력된 두 수의 덧셈, 뺄셈, 곱셈 결과값을 JSON 형태로 반환하기
    @GetMapping("/api/v1/calc")
    public CalculatorCalcResponse CalculateTwoNumbers(CalculatorAddRequest request) {
        int sum = request.getNum1() + request.getNum2();
        int minus = request.getNum1() - request.getNum2();
        int multiply = request.getNum1() * request.getNum2();

        return new CalculatorCalcResponse(sum, minus, multiply);
    }

    // 추가 예제 -> 문제 2: 날짜를 입력하면 요일을 JSON 형태로 반환하기
    @GetMapping("/getdate")
    public Map<String, String> getDate(@RequestParam String date) {
        Map<String, String> response = new HashMap<>();
        try {
            // 날짜 문자열을 LocalDate로 변환
            LocalDate dateObject = LocalDate.parse(date);

            // 요일 구하기 (첫 3글자만 반환)
            String dayOfTheWeek = dateObject.getDayOfWeek().toString().substring(0, 3);

            // JSON 응답 반환
            response.put("dayOfTheWeek", dayOfTheWeek);

        } catch (DateTimeParseException e) {
            response.put("error", "잘못된 날짜 형식입니다. (예: 2023-01-01)");
        }
        return response;
    }

    // 추가 예제 -> 문제 3: 여러개의 숫자를 배열 형태로 입력받아 총합을 반환
    @PostMapping("/sum")
    public int sumArrayofNumbers(@RequestBody CalculatorSumResponse response) {
        int sum = 0;
        for (int num : response.getNumbers()) {
            sum += num;
        }
        return sum;
    }
}

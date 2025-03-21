package com.group.libraryapp.dto.calculator.response;

public class CalculatorSumResponse {
    private int[] numbers;

    public CalculatorSumResponse() {} // 역직렬화를 해결하기 위해 추가한 기본 생성자

    public CalculatorSumResponse(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }
}

package com.group.libraryapp.dto.calculator.request;

public class CalculatorAddRequest {
    private int num1;
    private int num2;

    public CalculatorAddRequest(int num1, int num2) { // 강의에는 생성자 추가가 안 되어있음
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}

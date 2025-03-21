package com.group.libraryapp.dto.calculator.response;

public class CalculatorCalcResponse {
    private int add;
    private int minus;
    private int multiply;

    public CalculatorCalcResponse(int add, int minus, int multiply) {
        this.minus = minus;
        this.add = add;
        this.multiply = multiply;
    }

    public int getAdd() {
        return add;
    }

    public int getMinus() {
        return minus;
    }

    public int getMultiply() {
        return multiply;
    }
}

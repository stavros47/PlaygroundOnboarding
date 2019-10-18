package com.amdocs;

public class Multiply implements IMathOperation { 
    @Override
    public double evaluate(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
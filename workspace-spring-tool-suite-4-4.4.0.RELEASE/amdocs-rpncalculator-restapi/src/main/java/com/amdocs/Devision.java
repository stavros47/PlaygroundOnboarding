package com.amdocs;

public class Devision implements IMathOperation { 
    @Override
    public double evaluate(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }
}
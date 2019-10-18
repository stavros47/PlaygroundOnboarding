package com.amdocs;

public class Substraction implements IMathOperation { 
    @Override
    public double evaluate(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
}
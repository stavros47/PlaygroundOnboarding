package com.amdocs;

import java.util.HashMap;

public class MathFactory {

    private static HashMap<String,String> mathOperatorToClassNameMap = new HashMap<String,String>();

    static {
        mathOperatorToClassNameMap.put("+", "com.amdocs.Addition");
        mathOperatorToClassNameMap.put("-", "com.amdocs.Substraction");
        mathOperatorToClassNameMap.put("*", "com.amdocs.Multiply");
        mathOperatorToClassNameMap.put("/", "com.amdocs.Devision");
    }

    public static IMathOperation getObject (String mathOperator) {
        
        IMathOperation mathOperation = null;
        String className = mathOperatorToClassNameMap.get(mathOperator);

        try {
            mathOperation = (IMathOperation) Class.forName(className).newInstance();
        } catch (Exception e) {
            mathOperation = new NullMathObject();
        }

        return mathOperation;
    }
}
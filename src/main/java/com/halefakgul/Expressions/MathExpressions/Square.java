package com.halefakgul.Expressions.MathExpressions;

import com.halefakgul.Expressions.ExpressionBase;

public class Square extends ExpressionBase {
    public Square(){
        this.setCommands("karekok", "sqrt", "square");
        this.setCode("Math.sqrt($args)");
    }
}

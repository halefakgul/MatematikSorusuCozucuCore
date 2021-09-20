package com.halefakgul.Expressions.BaseExpressions;

import com.halefakgul.Expressions.ExpressionBase;

public class Print extends ExpressionBase {
    public Print(){
        this.setCommands("yazdir", "println", "print");
        this.setCode("System.out.println($args)");
    }
}

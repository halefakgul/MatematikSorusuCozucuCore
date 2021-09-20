package com.halefakgul.Expressions.BaseExpressions;

import com.halefakgul.Expressions.ExpressionBase;
import com.halefakgul.Expressions.IExpressionBase;

public class Solve extends ExpressionBase {
    public Solve(IExpressionBase exp){
        this.setCommands("coz", "solve");
        String solution = exp.getSolution();
        this.setCode("System.out.println(" + solution + ")");
    }
}

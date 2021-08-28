package com.halefakgul.Expressions.PrimaryExpression;

import com.halefakgul.Expressions.Expression;

public abstract class BasePrimaryExpression extends Expression implements IBasePrimaryExpression{
    private String[] exps;
    public BasePrimaryExpression(String[] exps){
        this.exps = exps;
    }

}

package com.halefakgul.Expressions.PrimaryExpressions;

import com.halefakgul.Expressions.FullExpression;

public abstract class BasePrimaryExpression extends FullExpression implements IBasePrimaryExpression{
    private String[] exps;
    public BasePrimaryExpression(){}
    public BasePrimaryExpression(String[] exps){
        this.exps = exps;
    }
    public void setExps(String[] exps){
        this.exps = exps;
    }
}

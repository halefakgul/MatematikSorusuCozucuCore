package com.halefakgul.Expressions.BasicMathExpressions;

import com.halefakgul.Expressions.BaseExpressions.ACE_Expression;

public class Square extends ACE_Expression {
    Double value;

    public Square(){

    }

    public Square(String[] arguments){
        super(arguments, new String[]{"square", "karekok"});
        initalize(arguments);
    }

    public void initalize(String[] arguments){
        Double value = Double.parseDouble(arguments[0]);
        Double pow = Double.parseDouble(arguments[1]);
        this.value = Math.pow(value, pow);
    }

    @Override
    public String toString(){
        return this.value + "";
    }
}

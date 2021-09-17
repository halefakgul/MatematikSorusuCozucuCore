package com.halefakgul.Expressions;

import com.halefakgul.Expressions.BasicMathExpressions.Square;

import java.util.ArrayList;

public class ExpressionManager {
    private ArrayList<IExpression> expressions;

    public ExpressionManager(){
        expressions = new ArrayList<>();
        expressions.add(new Square());
    }

    public void add(IExpression type){
        this.expressions.add(type);
    }


    public IExpression getExpression(String arg){
        for (IExpression exp : expressions){
            if (exp instanceof ICommand){
                if (((ICommand) exp).hasCommand(arg)){
                    return exp;
                }
            }
        }
        return null;
    }

    public Object getExpressionManager(){
        return this;
    }
    public ArrayList<IExpression> getExpressions(){
        return this.expressions;
    }
}

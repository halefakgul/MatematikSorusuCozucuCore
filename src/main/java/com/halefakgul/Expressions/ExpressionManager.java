package com.halefakgul.Expressions;

import java.util.ArrayList;

public class ExpressionManager {
    //Map<Expression, ExpressionTypes> expressions;
    ArrayList<ExpressionTypes> expressions;

    public ExpressionManager(){
        //expressions = new HashMap<>();
        //expressions.put((BasePrimaryExpression)new Calculate(), ExpressionTypes.CALCULATE);
        add(ExpressionTypes.CALCULATE);
        add(ExpressionTypes.CREATE);
        add(ExpressionTypes.DEFAULT);
    }


    private void add(ExpressionTypes type){
        this.expressions.add(type);
    }


    public Expression getExpression(String arg){
        /*for (ExpressionTypes t : expressions){
            if (t.hasAliase(arg)){
                switch(t){
                    case CALCULATE:
                        break;
                    case CREATE:
                            break;
                }
                return t;
            }
        }*/
        return null;
    }
}

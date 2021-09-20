package com.halefakgul.Expressions;


import java.util.ArrayList;

public class ExpressionManager {
    private ArrayList<IExpressionBase> expressions;

    public ExpressionManager(){
        expressions = new ArrayList<>();
    }

    public void add(IExpressionBase type){
        this.expressions.add(type);
    }


    public IExpressionBase getExpression(String arg){
        for (IExpressionBase exp : expressions){
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
    public ArrayList<IExpressionBase> getExpressions(){
        return this.expressions;
    }



    public String getCode(IExpressionBase exp){
        String code = exp.getCode();
        String allArgs = "";
        ArrayList<String> args = exp.getArguments();
        for (int i = 0; i < args.size(); i++){
            allArgs += args.get(i);
            if (i != args.size() - 1){
                allArgs += ", ";
            }
        }
        return code.replace("$args", allArgs);
    }
/*
    public String split(String readedExp){
        ArrayList<String> args = new ArrayList<>();
        args.add("");
        int counter = 0;
        for (char c : readedExp.toCharArray()){
            switch (c){
                case '(':
                    args.add("");
                    counter++;
                    break;
                case ')':
                    counter--;
                    break;
                default:
                    args.set(counter, args.get(counter) + c);
            }
        }
    }

    public String solve(String toSolve){
        IExpressionBase exp = getExpression(toSolve); //argumanları nasıl ayıklayacak
    }*/
}

package com.halefakgul;

import com.halefakgul.Expressions.BaseExpressions.UndefinedExp;
import com.halefakgul.Expressions.BaseExpressions.Print;
import com.halefakgul.Expressions.BaseExpressions.Solve;
import com.halefakgul.Expressions.ExpressionManager;
import com.halefakgul.Expressions.MathExpressions.Pow;
import com.halefakgul.Expressions.MathExpressions.Square;
import com.halefakgul.Functions.Compile;
import com.halefakgul.Functions.Execute;
import com.halefakgul.Functions.FunctionManager;
import com.halefakgul.Messager.MessageManager;

public class Core {
    public static String function;
    public static String[] arguments;
    public MessageManager messager;
    public FunctionManager functions;
    public ExpressionManager expressions;

    private String[] args;
    public Core(String[] args){
        this.args = args;

        messager = new MessageManager();
        functions = new FunctionManager();
        expressions = new ExpressionManager();

        expressions.add(new Square());
        expressions.add(new Pow());
        expressions.add(new Print());
        expressions.add(new Solve(new UndefinedExp()));


        function = args[0];
        arguments = new String[args.length - 1];
        for (int i = 0; i < arguments.length; i++){
            arguments[i] = args[i + 1];
        }

        functions.addFunction(new Compile(this));
        functions.addFunction(new Execute(this));
    }


    public void run(){
        functions.runFunction(function);
    }

    public MessageManager getMessager(){
        return this.messager;
    }

}

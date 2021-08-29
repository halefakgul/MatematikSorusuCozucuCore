package com.halefakgul.Expressions.PrimaryExpressions;

import com.halefakgul.Expressions.Expression;
import com.halefakgul.Expressions.FullExpression;

public class Calculate extends FullExpression {
    private void initalize(){
        setCommands("cal", "caliculate");
    }
    public Calculate(){
        initalize();
    }

    public Calculate(String ... args){
        initalize();
        setArguments(args);
    }

    public Double getResult() {
        return 0d + 5d;
    }
}

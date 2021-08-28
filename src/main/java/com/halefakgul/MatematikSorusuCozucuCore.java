package com.halefakgul;

import com.halefakgul.Expressions.Expression;
import com.halefakgul.Expressions.PrimaryExpression.Calculate;

public class MatematikSorusuCozucuCore {
    private static String primaryExpression;
    private static Object primaryExp;

    public static void main(String[] args) {
        if (args == null ||args.length == 0){
            return;
        }
        primaryExpression = args[0];
        String[] otherExpressions = new String[args.length - 1];
        for (int i = 1; i < otherExpressions.length; i++){
            otherExpressions[i] = args[i];
        }

        switch(primaryExpression){
            case "cal":
                primaryExp = new Calculate(otherExpressions);
                break;
        }

        System.out.println(((Expression) primaryExp).getResult());
    }
}

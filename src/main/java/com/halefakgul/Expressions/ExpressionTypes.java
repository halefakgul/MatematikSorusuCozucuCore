package com.halefakgul.Expressions;

import java.util.ArrayList;



//klavyeden girilen string değerin hangi işleme karşılık geldiğini bulmak için


//Expression manager kur arraylist e bütün expressionları al sonra içine getExpression gibi metodlar ekle aliase e uyan exp i return etsin
public enum ExpressionTypes {
    CALCULATE("calculate", "cal"),
    CREATE("create", "cr"),
    DEFAULT("", "<none>");

    private ArrayList<String> aliases;
    private Expression expression;

    ExpressionTypes(String... aliases){
        this.aliases = new ArrayList();
        for (String a: aliases){
            this.aliases.add(a);
        }
    }

    @Override
    public String toString(){
        return this.aliases.toString();
    }

    public Boolean hasAliase(String aliase){
        for (String a : aliases){
            if (a.equals(aliase)){
                return true;
            }
        }
        return false;
    }
}

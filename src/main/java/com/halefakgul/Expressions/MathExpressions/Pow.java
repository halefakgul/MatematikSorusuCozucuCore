package com.halefakgul.Expressions.MathExpressions;

import com.halefakgul.Expressions.ExpressionBase;

import java.util.ArrayList;

public class Pow extends ExpressionBase {
    public Pow(){
        this.setCommands("us", "kuvvet", "pow", "power");
        this.setCode("Math.pow($args)");
    }

    @Override
    public String getSolution(){
        ArrayList<String> args = getArguments();
        String a = args.get(0);
        String b = args.get(1);
        String cevap_satir1 = "Bir sayinin ussu girilen A sayisinin B ile kendisi ile carpilmasidir. Ornekte";
        String cevap_satir2 = "";
        for (int i = 0 ; i < Integer.parseInt(b); i++){
            cevap_satir2 += a + " * ";
        }
        cevap_satir2 += "\nyapılarak sonuca ulaşılmıştır";
        return cevap_satir1 + "\n" + cevap_satir2;
    }
}

package com.halefakgul;

import com.halefakgul.Functions.Compile;
import com.halefakgul.Functions.Execute;
import com.halefakgul.Messager.MessageManager;

public class Core {
    public static String function;
    public static String[] arguments;
    public MessageManager messager = new MessageManager();


    private String[] args;
    public Core(String[] args){
        this.args = args;
    }


    public void run(){
        function = args[0];
        arguments = new String[args.length - 1];
        for (int i = 0; i < arguments.length; i++){
            arguments[i] = args[i + 1];
        }

        switch(function){
            case "compile":
                new Compile(this);
                break;
            case "execute":
                new Execute(this);
                break;
            default:
                System.out.println("Hello There! Version: MatematikSorusuCozucuCore v0.1");
        }
    }

    public MessageManager getMessager(){
        return this.messager;
    }

}

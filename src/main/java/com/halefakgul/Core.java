package com.halefakgul;

import com.halefakgul.Functions.Compile;
import com.halefakgul.Functions.Execute;
import com.halefakgul.Functions.FunctionManager;
import com.halefakgul.Messager.MessageManager;

public class Core {
    public static String function;
    public static String[] arguments;
    public MessageManager messager = new MessageManager();
    public FunctionManager functions = new FunctionManager();


    private String[] args;
    public Core(String[] args){
        this.args = args;

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

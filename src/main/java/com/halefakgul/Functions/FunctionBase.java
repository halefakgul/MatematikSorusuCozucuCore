package com.halefakgul.Functions;

import com.halefakgul.Core;
import com.halefakgul.Messager.MessageManager;

public abstract class FunctionBase implements IFunctionBase{
    private String function;
    public String[] arguments;

    public final Core core;
    public final MessageManager messager;


    public FunctionBase(Core core){
        this.core = core;
        this.messager = core.getMessager();
        this.function = core.function;
        this.arguments = core.arguments;

    }

    public String toString(){
        return this.getClass().getName();
    }

    public String getFunction(){
        return this.function;
    }
    public void setFunction(String function){
        this.function = function;
    }

}

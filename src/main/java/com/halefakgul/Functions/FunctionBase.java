package com.halefakgul.Functions;

import com.halefakgul.Core;
import com.halefakgul.Messager.MessageManager;

public abstract class FunctionBase {
    public String function;
    public String[] arguments;

    public final Core core;
    public final MessageManager messager;


    public FunctionBase(Core core){
        this.core = core;
        this.messager = core.getMessager();
        this.function = core.function;
        this.arguments = core.arguments;

    }

}

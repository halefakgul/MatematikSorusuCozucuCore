package com.halefakgul.Functions;

import java.util.ArrayList;

public class FunctionManager {

    private ArrayList<FunctionBase> functions;

    public FunctionManager(){
        functions = new ArrayList<>();
    }


    public void addFunction(FunctionBase function){
        this.functions.add(function);
    }

    public void removeFunction(FunctionBase function){
        this.functions.remove(function);
    }

    public void removeFunction(String functionCommand){
        for (FunctionBase fb : this.functions){
            if (fb.getFunction().equals(functionCommand)){
                this.functions.remove(fb);
                return;
            }
        }
    }


    public FunctionBase getFunction(String calledFunctionCommand){
        for (FunctionBase fb : this.functions){
            if (fb == null || fb.getFunction() == null){
                continue;
            }
            if (fb.getFunction().equals(calledFunctionCommand)){
                return fb;
            }
        }
        return null;
    }

    public void runFunction(String calledFunctionCommand){
        FunctionBase fb = getFunction(calledFunctionCommand);
        if (fb == null){
            System.out.println("Undefined command: "+ calledFunctionCommand +".\nMSCC Version: v0.1");
            return;
        }
        fb.run();
    }
}

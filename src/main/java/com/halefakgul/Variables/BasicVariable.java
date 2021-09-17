package com.halefakgul.Variables;

public class BasicVariable<T> extends Variable<T>{
    @Override
    public Object getResult() {
        return "";
    }

    @Override
    public String toString(){
        return (T)(this.value) + "";
    }
}

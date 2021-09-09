package com.halefakgul.Messager;

public class MessageManager {

    public String getMessage(Messages message){
        return message.message;
    }
    public void printMessage(Messages message){
        System.out.println(message.message);
    }
    public void printErrorMessage(Messages message){
        System.err.println(message.message);
    }
}

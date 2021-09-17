package com.halefakgul.Expressions.BaseExpressions;

import com.halefakgul.Expressions.Expression;
import com.halefakgul.Expressions.ICommand;

import java.util.ArrayList;

public abstract class C_Expression extends Expression implements ICommand {
    private ArrayList<String> commands;


    private void initalize(){
        this.commands = new ArrayList<>();
    }

    public C_Expression(){
        initalize();
    }
    public C_Expression(String ... arguments){
        initalize();
    }
    public C_Expression(String[] arguments, String[] commands){
        initalize();
        setCommands(commands);
    }

    public void setCommands(String ... commands){
        for (String command : commands){
            this.commands.add(command);
        }
    }

    public void setCommands(ArrayList<String> commands){
        this.commands = commands;
    }


    public Boolean hasCommand(String command){
        for(String c : commands){
            if (c.equals(command)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getCommands(){
        return this.commands;
    }

}

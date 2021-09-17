package com.halefakgul.Expressions.BaseExpressions;

import com.halefakgul.Expressions.Expression;
import com.halefakgul.Expressions.IArguments;
import com.halefakgul.Expressions.ICommand;
import com.halefakgul.Expressions.IExplainable;

import java.util.ArrayList;

public abstract class ACE_Expression extends Expression implements IArguments, ICommand, IExplainable {
    private ArrayList<String> arguments;
    private ArrayList<String> commands;

    private void initalize(){
        this.arguments = new ArrayList<>();
        this.commands = new ArrayList<>();
    }
    public ACE_Expression(){
        initalize();
    }
    public ACE_Expression(String ... arguments){
        initalize();
        setArguments(arguments);
    }
    public ACE_Expression(String[] arguments, String[] commands){
        initalize();
        setArguments(arguments);
        setCommands(commands);
    }

    public void setArguments(String ... arguments){
        for (String argument : arguments){
            this.arguments.add(argument);
        }
    }
    public void setArguments(ArrayList<String> arguments){
        for (String argument : arguments){
            this.arguments.add(argument);
        }
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

    public String getSolution() {
        return null;
    }
}

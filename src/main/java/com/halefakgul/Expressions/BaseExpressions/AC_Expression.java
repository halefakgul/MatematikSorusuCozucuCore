package com.halefakgul.Expressions.BaseExpressions;

import com.halefakgul.Expressions.Expression;
import com.halefakgul.Expressions.IArguments;
import com.halefakgul.Expressions.ICommand;

import java.util.ArrayList;

public abstract class AC_Expression extends Expression implements IArguments, ICommand {
    private ArrayList<String> arguments;
    private ArrayList<String> commands;

    private void initalize(){
        this.arguments = new ArrayList<>();
        this.commands = new ArrayList<>();
    }
    public AC_Expression(){
        initalize();
    }
    public AC_Expression(String ... arguments){
        initalize();
        setArguments(arguments);
    }
    public AC_Expression(String[] arguments, String[] commands){
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
}

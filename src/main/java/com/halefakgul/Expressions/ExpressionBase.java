package com.halefakgul.Expressions;

import java.util.ArrayList;

public abstract class ExpressionBase implements IExpressionBase, ICommand {
    private String code = "";
    private String imports = "";
    private String solution = "";
    public ArrayList<String> arguments;
    public ArrayList<String> commands;
    public int argsAmount = 0;

    private void initalize(){
        this.arguments = new ArrayList<>();
        this.commands = new ArrayList<>();
    }
    public ExpressionBase(){
        initalize();
    }
    public ExpressionBase(String ... commands){
        initalize();
        setCommands(arguments);
    }


    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }


    public int getArgsAmount(){
        return this.argsAmount;
    }

    public String toString(){
        return code;
    }


    public void setArguments(String ... arguments){
        for (String argument : arguments){
            this.arguments.add(argument);
        }
        this.argsAmount = arguments.length;
    }
    public void setArguments(ArrayList<String> arguments){
        for (String argument : arguments){
            this.arguments.add(argument);
        }
        this.argsAmount = arguments.size();
    }
    public ArrayList<String> getArguments(){
        return this.arguments;
    }

    public void addArgument(String argument){
        this.arguments.add(argument);
    }


    public void clearArguments(){
        this.arguments = new ArrayList<>();
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

    public String getImports(){
        return this.imports;
    }
    public void setImports(String imports){
        this.imports = imports;
    }
}

package com.halefakgul.Expressions;

import java.util.ArrayList;

public interface ICommand {
    public void setCommands(String ... commands);
    public void setCommands(ArrayList<String> commands);
    public ArrayList<String> getCommands();
    public Boolean hasCommand(String command);

}
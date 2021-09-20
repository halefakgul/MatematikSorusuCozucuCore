package com.halefakgul.Expressions;

import java.util.ArrayList;

public interface IExpressionBase {
    public String getCode();
    public void setCode(String code);
    public String toString();
    public String getImports();
    public void setImports(String imports);
    public String getSolution();
    public int getArgsAmount();
    public void addArgument(String argument);
    public void clearArguments();
    public ArrayList<String> getArguments();

}

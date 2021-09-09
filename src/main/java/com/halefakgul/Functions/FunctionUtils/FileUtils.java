package com.halefakgul.Functions.FunctionUtils;

import java.io.File;

public class FileUtils {
    public static File getFileIfAvailable(String extension, String ... arguments){
        String fileName = "";
        for (String argument : arguments){
            if (argument.endsWith(extension)){
                return new File(argument);
            }else{
                fileName += argument;
            }
        }
        return new File(fileName);
    }
}

package com.halefakgul.Functions;

import com.halefakgul.Core;
import com.halefakgul.Functions.FunctionUtils.FileUtils;
import com.halefakgul.Messager.Messages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Execute extends FunctionBase{
    public Execute(Core core) {
        super(core);
        this.setFunction("execute");
    }
    public void run(){

        File toExecute = null;
        try {
            toExecute = FileUtils.getFileIfAvailable(".mscc", arguments);
            ProcessBuilder processBuilder = new ProcessBuilder("java", toExecute.getName().replace(".mscc", ""));
            InputStream stream = processBuilder.start().getInputStream();
            Scanner ss = new Scanner(stream);
            while (ss.hasNext()){
                System.out.println(ss.next());
            }
        }catch(FileNotFoundException | NullPointerException e){
            messager.printErrorMessage(Messages.fileNotFoundMessage);
            e.printStackTrace();
        }catch(IOException e){
            messager.printErrorMessage(Messages.ioExceptionMessage);
            e.printStackTrace();
        }
    }
}

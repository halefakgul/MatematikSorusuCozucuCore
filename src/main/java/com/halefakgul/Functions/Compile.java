package com.halefakgul.Functions;

import com.halefakgul.Core;
import com.halefakgul.Functions.FunctionUtils.FileUtils;
import com.halefakgul.Messager.Messages;

import java.io.*;
import java.util.Scanner;

public class Compile extends FunctionBase{
    private File compiled = null;
    private Scanner file = null;
    private File javaOutput = null;
    private String javaOutputFileName = "";
    private String imports = "";
    private PrintWriter printer = null;

    public Compile(Core core){
        super(core);
        if (arguments == null || arguments.length == 0){
            messager.printErrorMessage(Messages.fileNotFoundMessage);
            return;
        }
        try {
            compiled = FileUtils.getFileIfAvailable(".msc", arguments);
            file = new Scanner(compiled);
            javaOutputFileName = compiled.getName().replace(".msc", ".java");
            javaOutput = new File(javaOutputFileName);
            if (!javaOutput.exists()){
                javaOutput.createNewFile();
            }
            printer = new PrintWriter(javaOutput);


            printer.print(getClassDef());//public class %classname% { psvm(){
            String code = "";
            while (file.hasNextLine()){
                code += file.nextLine();
            }
            String[] lines = code.split(";");//splits for every ;
            for (String line : lines){

                if (line.startsWith("println")){
                    line = "System.out." + line;
                }
                printer.print(line + "; ");//replaces the ;
            }

            printer.print("}}");
            printer.close();

            InputStream stream = new ProcessBuilder("javac", javaOutput.getName()).start().getInputStream();
            Scanner ss = new Scanner(stream);
            while (ss.hasNext()){
                System.out.println(ss.next());
            }
            javaOutput.deleteOnExit();
        } catch (FileNotFoundException | NullPointerException e) {
            messager.printErrorMessage(Messages.fileNotFoundMessage);
            e.printStackTrace();
        } catch (IOException e){
            messager.printErrorMessage(Messages.ioExceptionMessage);
            e.printStackTrace();
        }
    }

    private String getClassDef(){
        return "public class "+ compiled.getName().replace(".msc", "") +"{+ " + imports + "public static void main(String[] args){ ";
    }
}

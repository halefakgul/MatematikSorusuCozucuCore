package com.halefakgul;

import java.io.*;
import java.util.Scanner;

public class MatematikSorusuCozucuCore {
    private static String function;
    private static String[] arguments;

    private static String fileNotFoundMessage = "An input required. (Ex: compile test.msc)";
    private static String ioExceptionMessage = "IOException has occoured while file is exporting";

    public static void main(String[] args) {
        if (args == null ||args.length == 0){
            return;
        }
        function = args[0];
        arguments = new String[args.length - 1];
        for (int i = 0; i < arguments.length; i++){
            arguments[i] = args[i + 1];
        }

        switch(function){
            case "compile":
                compile();
                break;
            case "execute":
                execute();
                break;
            default:
                System.out.println("Hello There! Version: MatematikSorusuCozucuCore v0.1");
        }

        //System.out.println(((Expression) primaryExp).getResult());
    }


    private static void compile(){
        if (arguments == null || arguments.length == 0){
            System.err.println(fileNotFoundMessage);
            return;
        }
        File compiled = null;
        Scanner file = null;
        File javaOutput = null;
        String javaOutputFileName;
        PrintWriter printer = null;
        try {
            compiled = getFileIfAvailable(".msc", arguments);
            file = new Scanner(compiled);
            javaOutputFileName = compiled.getName().replace(".msc", ".java");
            javaOutput = new File(javaOutputFileName);
            if (!javaOutput.exists()){
                javaOutput.createNewFile();
            }
            printer = new PrintWriter(javaOutput);


            printer.print("public class "+ compiled.getName().replace(".msc", "") +"{public static void main(String[] args){ ");
            String code = "";
            while (file.hasNextLine()){
                code += file.nextLine();
            }
            String[] lines = code.split(";");
            for (String line : lines){
                if (line.startsWith("println")){
                    line = "System.out." + line;
                }
                printer.print(line + "; ");
            }

            printer.print("}}");
            printer.close();

            InputStream stream = new ProcessBuilder("javac", javaOutput.getName()).start().getInputStream();

            Scanner ss = new Scanner(stream);
            while (ss.hasNext()){
                System.out.println(ss.next());
            }
            //javaOutput.deleteOnExit();
        } catch (FileNotFoundException | NullPointerException e) {
            System.err.println(fileNotFoundMessage);
            e.printStackTrace();
        } catch (IOException e){
            System.err.println(ioExceptionMessage);
            e.printStackTrace();
        }
    }

    private static void execute(){
        File toExecute = null;
        try {
            toExecute = getFileIfAvailable(".msc", arguments);
            ProcessBuilder processBuilder = new ProcessBuilder("java", toExecute.getName().replace(".msc", ""));
            InputStream stream = processBuilder.start().getInputStream();
            Scanner ss = new Scanner(stream);
            while (ss.hasNext()){
                System.out.println(ss.next());
            }
        }catch(FileNotFoundException | NullPointerException e){
            System.err.println(fileNotFoundMessage);
            e.printStackTrace();
        }catch(IOException e){
            System.err.println(ioExceptionMessage);
            e.printStackTrace();
        }
    }

    private static File getFileIfAvailable(String extension, String ... arguments){
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

package com.halefakgul.Functions;

import com.halefakgul.Core;
import com.halefakgul.Expressions.BaseExpressions.Solve;
import com.halefakgul.Expressions.ExpressionManager;
import com.halefakgul.Expressions.IExpressionBase;
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
    private ExpressionManager expressions;

    public Compile(Core core){
        super(core);
        this.setFunction("compile");
        this.expressions = core.expressions;
    }


    public void run(){
        if (arguments == null || arguments.length == 0){
            messager.printErrorMessage(Messages.fileNotFoundMessage);
            return;
        }
        try {
            compiled = FileUtils.getFileIfAvailable(".mscc", arguments);
            file = new Scanner(compiled);
            javaOutputFileName = compiled.getName().replace(".mscc", ".java");
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
            String[] identified = code.split(";");//splits for every ;
            for (String section : identified){
                IExpressionBase exp = null;
                String readedWords = "";
                Boolean isSolve = false;
                for (String word : section.split(" ")){
                    if (exp != null){
                        exp.addArgument(word);
                        continue;
                    }
                    exp = expressions.getExpression(word);
                    if (exp instanceof Solve){
                        isSolve = true;
                        exp = null;
                        continue;
                    }

                    if (exp == null){
                        readedWords += word + " ";
                        continue;
                    }

                }
                if (isSolve && exp != null){
                    Solve solve = new Solve(exp);
                    printer.print(solve.getCode() + ";");
                    isSolve = false;
                }else if (exp != null){
                    printer.print(readedWords + expressions.getCode(exp) + ";");
                    exp.clearArguments();
                }else{
                    printer.print(section +"; ");
                }
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
            messager.printErrorMessage(Messages.fileNotFoundMessage);
            e.printStackTrace();
        } catch (IOException e){
            messager.printErrorMessage(Messages.ioExceptionMessage);
            e.printStackTrace();
        }
    }

    private String getClassDef(){
        return "public class "+ compiled.getName().replace(".mscc", "") +"{ " + imports + "public static void main(String[] args){ ";
    }
}

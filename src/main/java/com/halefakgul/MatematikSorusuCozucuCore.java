package com.halefakgul;


public class MatematikSorusuCozucuCore {
    public static void main(String[] args) {


        if (args == null ||args.length == 0){
            return;
        }
        new Core(args).run();
    }
}

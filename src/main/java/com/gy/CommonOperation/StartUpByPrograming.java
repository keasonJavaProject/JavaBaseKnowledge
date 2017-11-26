package com.gy.CommonOperation;

import java.util.Arrays;

public class StartUpByPrograming {
    static String cmd = "java StartUpByPrograming hello";

    public static void main(String[] args) throws Exception{
        if (args.length >=1 ) {
            System.out.println("run from main,args:"+Arrays.toString(args));
        } else {
            Process process = Runtime.getRuntime().exec(cmd);
            int exitValue = process.waitFor();
            System.out.println("exit value="+ exitValue);
        }
    }
}

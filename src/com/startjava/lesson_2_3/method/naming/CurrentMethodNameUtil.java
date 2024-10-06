package com.startjava.lesson_2_3.method.naming;

public class CurrentMethodNameUtil {

    public static String getName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
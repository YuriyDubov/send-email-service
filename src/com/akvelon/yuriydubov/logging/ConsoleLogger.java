package com.akvelon.yuriydubov.logging;

public class ConsoleLogger implements Ilogger {

    @Override
    public void log(String msg) {
        System.out.println(msg);
    }
}

package com.akvelon.yuriydubov.logging;

public class Logger {
    private Ilogger logger;

    public  Logger(Ilogger logger) {
        this.logger = logger;
    }

    public void log( String msg) {
        logger.log(msg);
    }
}

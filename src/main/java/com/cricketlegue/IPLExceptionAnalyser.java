package com.cricketlegue;

import java.lang.reflect.Type;

public class IPLExceptionAnalyser extends Exception{
    enum ExceptionType{
        FILE_NOT_FOUND
    }
    ExceptionType type;

    public IPLExceptionAnalyser(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLExceptionAnalyser(String message,String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}

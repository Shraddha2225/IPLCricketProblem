package com.cricketlegue;
public class IPLExceptionAnalyser extends Exception{
    enum ExceptionType{
        NO_CENSUS_DATA,FILE_NOT_FOUND,NO_DATA_AVAIL
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

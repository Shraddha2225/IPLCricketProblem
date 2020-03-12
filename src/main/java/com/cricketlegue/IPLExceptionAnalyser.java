package com.cricketlegue;
public class IPLExceptionAnalyser extends Throwable {
    enum ExceptionType{
        FILE_NOT_FOUND,NO_DATA_AVAIL,CENSUS_FILE_PROBLEM;

    }
    ExceptionType type;

    public IPLExceptionAnalyser(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLExceptionAnalyser(String message,String name,Throwable cause) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}

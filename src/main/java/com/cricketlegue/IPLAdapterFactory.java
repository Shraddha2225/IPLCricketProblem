package com.cricketlegue;

import java.util.Map;

public class IPLAdapterFactory {
    public Map<String, IPLCricketDTO> getIplData(IPLCricketAnalyser.CSVType type, String filePath) throws IPLExceptionAnalyser {
        if (type.equals(IPLCricketAnalyser.CSVType.RUNS)) {
            return new IPLRunAdapter().loadIplData(filePath);
        }
        if (type.equals(IPLCricketAnalyser.CSVType.WICKETS)) {
            return new IPLWicketAdapter().loadIplData(filePath);
        }
        throw new IPLExceptionAnalyser("INVALID CSV TYPE", IPLExceptionAnalyser.ExceptionType.NO_DATA_AVAIL);


    }

}

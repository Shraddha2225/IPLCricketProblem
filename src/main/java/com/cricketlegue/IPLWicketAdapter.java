package com.cricketlegue;

import java.util.Map;

public class IPLWicketAdapter extends IplAdapter {
    @Override
    public Map<String, IPLCricketDTO> loadIplData(String csvFilePath) throws IPLExceptionAnalyser {
        Map<String, IPLCricketDTO> iplMap = super.loadIplData(IPLCricketWicketCSV.class, csvFilePath);
        return iplMap;
    }
}

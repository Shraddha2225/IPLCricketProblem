package com.cricketlegue;

import java.util.Map;

public class IPLRunAdapter extends IplAdapter {
    @Override
    public Map<String, IPLCricketDTO> loadIplData(String csvFilePath) throws IPLExceptionAnalyser {
        Map<String, IPLCricketDTO> iplMap = super.loadIplData(IPLCricketRunCSV.class, csvFilePath);
        return iplMap;
    }

}

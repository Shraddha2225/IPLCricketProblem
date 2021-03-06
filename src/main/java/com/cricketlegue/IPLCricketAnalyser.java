package com.cricketlegue;

import com.csvfile.CSVBuilderFactory;
import com.csvfile.ICSVBuilder;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IPLCricketAnalyser extends Throwable {
    Map<SortedField, Comparator<IPLCricketDTO>> sortedMap=null;
   Map<String, IPLCricketDTO> iplCricketMap =new HashMap<>();
    private List<IPLCricketDTO> iplCricketDTOList;

    public enum CSVType{
        RUNS,WICKETS;
    }

    public IPLCricketAnalyser() {
        sortedMap = new HashMap<>();
        Comparator<IPLCricketDTO> avgStrike = Comparator.comparing((census -> census.average));

        this.sortedMap.put(SortedField.AVERAGE,Comparator.comparing(census -> census.average));
        this.sortedMap.put(SortedField.STRIKE_RATE,Comparator.comparing(census -> census.strikingrates));
        this.sortedMap.put(SortedField.FOUR_AND_SIX,Comparator.comparing(census -> census.fours + census.sixs));
        this.sortedMap.put(SortedField.SIX_FOUR, new CompareSixAndFour().thenComparing((census -> census.strikingrates)));
        this.sortedMap.put(SortedField.FIVE_FOUR, new CompareFiveAndFour().thenComparing((census -> census.strikingrates)));

        Comparator<IPLCricketDTO> runAverage = Comparator.comparing((census -> census.runs));
        this.sortedMap.put(SortedField.RUNS,Comparator.comparing(census -> census.runs));
        this.sortedMap.put(SortedField.ECONOMY, Comparator.comparing(census -> census.economy));

    }

    public void loadIplData(CSVType type, String FilePath) throws IPLExceptionAnalyser {
        iplCricketMap = new IPLAdapterFactory().getIplData(type, FilePath);
    }

    public String getSortedIPLData(SortedField field) throws IPLExceptionAnalyser {
        if (iplCricketMap == null || iplCricketMap.size() == 0) {
            throw new IPLExceptionAnalyser("No Data Available",IPLExceptionAnalyser.ExceptionType.NO_DATA_AVAIL);
        }
        iplCricketDTOList = iplCricketMap.values().stream().collect(Collectors.toList());
        this.sort(iplCricketDTOList, this.sortedMap.get(field).reversed());
        String sortedStateCensusJson = new Gson().toJson(iplCricketDTOList);
        return sortedStateCensusJson;
    }

    private void sort( List<IPLCricketDTO> iplCricketDTOList, Comparator<IPLCricketDTO> iplCSVComparator) {
        for (int i = 0; i < this.iplCricketDTOList.size() - 1; i++) {
            for (int j = 0; j < this.iplCricketDTOList.size() - i - 1; j++) {
                IPLCricketDTO census1 = this.iplCricketDTOList.get(j);
                IPLCricketDTO census2 = this.iplCricketDTOList.get(j + 1);
                if (iplCSVComparator.compare(census1, census2) > 0) {
                    this.iplCricketDTOList.set(j, census2);
                    this.iplCricketDTOList.set(j + 1, census1);
                }
            }
        }
    }
}




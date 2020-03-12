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

    public IPLCricketAnalyser() {
        sortedMap = new HashMap<>();
        this.sortedMap.put(SortedField.AVERAGE,Comparator.comparing(census -> census.average));
        this.sortedMap.put(SortedField.STRIKE_RATE,Comparator.comparing(census -> census.strikingrates));
        this.sortedMap.put(SortedField.FOUR_AND_SIX,Comparator.comparing(census -> census.fours + census.sixs));
        this.sortedMap.put(SortedField.RUNS,Comparator.comparing(census -> census.runs));
        this.sortedMap.put(SortedField.ECONOMY, Comparator.comparing(census -> census.economy));
    }

    public void loadIplRunData(String FilePath) throws IPLExceptionAnalyser {
        iplCricketMap = new IplDataLoader().loadIplData(IPLCricketRunCSV.class, FilePath);
    }

    public void loadIPLCricketWicketsData(String FilePath) throws IPLExceptionAnalyser {
        iplCricketMap = new IplDataLoader().loadIplData(IPLCricketWicketCSV.class, FilePath);
    }

    public String getSortedIPLData(SortedField field) throws IPLExceptionAnalyser {
        if (iplCricketMap == null || iplCricketMap.size() == 0) {
            throw new IPLExceptionAnalyser("No Census Data",IPLExceptionAnalyser.ExceptionType.NO_CENSUS_DATA);
        }
        iplCricketDTOList = iplCricketMap.values().stream().collect(Collectors.toList());
        this.sort(iplCricketDTOList, this.sortedMap.get(field));
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




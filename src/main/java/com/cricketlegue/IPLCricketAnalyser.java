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

    }
    public void loadIplData(String FilePath) throws IPLExceptionAnalyser {
        try (Reader reader = Files.newBufferedReader(Paths.get(FilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator <IPLCricketRunCSV> iterator = csvBuilder.getCSVFileIterator(reader, IPLCricketRunCSV.class);
            Iterable< IPLCricketRunCSV > csvIterable = () -> iterator;
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .forEach(csvName -> iplCricketMap.put(csvName.player,new IPLCricketDTO(csvName)));
            System.out.println(iplCricketMap);
           // return iplCricketMap.size();
        } catch (IOException e) {
            throw new IPLExceptionAnalyser(e.getMessage(), IPLExceptionAnalyser.ExceptionType.CENSUS_FILE_PROBLEM);
        }
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




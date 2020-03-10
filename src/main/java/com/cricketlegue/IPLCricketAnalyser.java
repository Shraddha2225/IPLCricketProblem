package com.cricketlegue;

import com.csvfile.CSVBuilderException;
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

public class IPLCricketAnalyser {
    List<IPLCricketRunCSV> list = new ArrayList<>();

    public int loadIplRunData(String csvFilePath) throws IPLExceptionAnalyser, IOException, CSVBuilderException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List playersList = icsvBuilder.getCSVFileList(reader, IPLCricketRunCSV.class);
            playersList.stream().filter(CensusData -> list.add((IPLCricketRunCSV) CensusData)).collect(Collectors.toList());
            return playersList.size();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            //throw new IPLExceptionAnalyser("FILE_NOT_FOUND",IPLExceptionAnalyser.ExceptionType.FILE_NOT_FOUND);
            e.printStackTrace();
        }
        return 0;
    }

    public List sortingPlayersDataInReverse() throws IPLExceptionAnalyser {
        if(list == null || list.size() == 0) {
            throw new IPLExceptionAnalyser("NO_CENSUS_DATA", IPLExceptionAnalyser.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().sorted(Comparator.comparing(IPLCricketRunCSV::getAverage).reversed()).collect(Collectors.toList());
        return sortedList;
    }

}




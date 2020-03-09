package com.cricketlegue;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IPLCricketAnalyser {
    public int loadIplData(String CsvFilePath) throws IPLExceptionAnalyser {
        try (Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath))) {
                CsvToBeanBuilder<IPLCricketRunCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                csvToBeanBuilder.withType(IPLCricketRunCSV.class);
                csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                CsvToBean<IPLCricketRunCSV> csvToBean = csvToBeanBuilder.build();
                Iterator<IPLCricketRunCSV> ipLleagueAnalysisCSVIterator = csvToBean.iterator();
                Iterable<IPLCricketRunCSV> csvIterable=() -> ipLleagueAnalysisCSVIterator;
                int numOfPlayers= (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
                return numOfPlayers;
            } catch ( IOException e) {
                throw new IPLExceptionAnalyser(e.getMessage(), IPLExceptionAnalyser.ExceptionType.FILE_NOT_FOUND);
            }
        }
}


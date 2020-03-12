package com.cricketlegue;

import com.csvfile.CSVBuilderFactory;
import com.csvfile.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IplDataLoader {
    Map<String, IPLCricketDTO> iplCricketMap = new HashMap<>();

    public <E> Map<String, IPLCricketDTO> loadIplData(Class<E> IplCSV, String FilePath) throws IPLExceptionAnalyser {
        try (Reader reader = Files.newBufferedReader(Paths.get(FilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> iterator = csvBuilder.getCSVFileIterator(reader, IplCSV);
            Iterable<E> csvIterable = () -> iterator;
            if (IplCSV.getName() == "com.cricketlegue.IPLCricketRunCSV") {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPLCricketRunCSV.class::cast)
                        .forEach(csvName -> iplCricketMap.put(csvName.player, new IPLCricketDTO(csvName)));
            }
            else if (IplCSV.getName() == "com.cricketlegue.IPLCricketWicketCSV") {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map((IPLCricketWicketCSV.class::cast))
                        .forEach(csvName -> iplCricketMap.put(csvName.player, new IPLCricketDTO(csvName)));
            }
            // System.out.println(iplCricketMap);
            return iplCricketMap;
        } catch (IOException ex) {
            throw new IPLExceptionAnalyser(ex.getMessage(), IPLExceptionAnalyser.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }


}

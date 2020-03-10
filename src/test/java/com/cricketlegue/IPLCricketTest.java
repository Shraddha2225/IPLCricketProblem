package com.cricketlegue;
import com.csvfile.CSVBuilderException;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class IPLCricketTest {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenMostRunFile_ShouldReturnCorrectData() throws IOException, IPLExceptionAnalyser, CSVBuilderException {
        IPLCricketAnalyser ipLleagueAnalysis = new IPLCricketAnalyser();
        int totalRecords = ipLleagueAnalysis.loadIplRunData(IPL_MOST_RUNS_CSV_FILE_PATH);
        Assert.assertEquals(101,totalRecords);
    }

    @Test
    public void givenMostRunFile_ShouldReturnTopRunAverage() throws IPLExceptionAnalyser, IOException, CSVBuilderException {
        IPLCricketAnalyser ipLleagueAnalysis = new IPLCricketAnalyser();
        ipLleagueAnalysis.loadIplRunData(IPL_MOST_RUNS_CSV_FILE_PATH);
        List<IPLCricketRunCSV> sortedCensusData = ipLleagueAnalysis.sortingPlayersDataInReverse();
        Assert.assertEquals(83.2,sortedCensusData.get(0).average,0);
    }

    @Test
    public void givenIncorrectRunsFile_ShouldThrowException() throws IPLExceptionAnalyser, IOException, CSVBuilderException {
        IPLCricketAnalyser ipLleagueAnalysis = new IPLCricketAnalyser();
        ExpectedException exception = ExpectedException.none();
        exception.expect(IPLExceptionAnalyser.class);
        ipLleagueAnalysis.loadIplRunData(IPL_MOST_RUNS_CSV_FILE_PATH);
    }

}

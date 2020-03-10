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
    /*@Test
    public void givenMostRunFile_ShouldReturnCorrectData() throws IOException, IPLExceptionAnalyser, CSVBuilderException {
        IPLCricketAnalyser ipLleagueAnalysis = new IPLCricketAnalyser();
        int totalRecords = ipLleagueAnalysis.loadIplData(IPL_MOST_RUNS_CSV_FILE_PATH);
        Assert.assertEquals(0,totalRecords);
    }*/

    @Test
    public void givenMostRunFile_WhenSorted_ShouldReturnTopRunAverage() throws IPLExceptionAnalyser{
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.AVERAGE);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
        Assert.assertEquals("MS Dhoni", censusCSV[censusCSV.length-1].player);
    }

    @Test
    public void givenIPLRunsData_whenSorted_ShouldReturnStrikkingRate() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.STRIKE_RATE);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
        Assert.assertEquals("Ishant Sharma", censusCSV[censusCSV.length-1].player);
    }

    @Test
    public void givenIPLRunsData_whenSorted_ShouldReturnMaxSixAndFour() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.FOUR_AND_SIX);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
        Assert.assertEquals("Andre Russell", censusCSV[censusCSV.length-1].player);
    }


    @Test
    public void givenIPLRunsData_whenSorted_ShouldReturnTopStrikeRate() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.FOUR_AND_SIX);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
       // Assert.assertEquals("Andre Russell", censusCSV[censusCSV.length-1].player);
        Assert.assertEquals(204.81, censusCSV[censusCSV.length-1].strikingrates,00);
    }
}

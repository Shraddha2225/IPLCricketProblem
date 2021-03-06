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
    private  static final String IPL_MOST_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenMostRunFile_WhenSorted_ShouldReturnTopRunAverage() throws IPLExceptionAnalyser{
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.RUNS,IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.AVERAGE);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
        Assert.assertEquals("MS Dhoni", censusCSV[0].player);
    }

    @Test
    public void givenIPLRunsData_whenSorted_ShouldReturnStrikkingRate() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.RUNS,IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.STRIKE_RATE);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
        Assert.assertEquals("Ishant Sharma", censusCSV[0].player);
    }

    @Test
    public void givenIPLRunsData_whenSorted_ShouldReturnMaxSixAndFour() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.RUNS,IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.FOUR_AND_SIX);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
        Assert.assertEquals("Andre Russell", censusCSV[0].player);
    }


    @Test
    public void givenIPLRunsData_whenSortedOn6And4_ShouldReturnTopStrikeRate() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.RUNS,IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.SIX_FOUR);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
       // Assert.assertEquals("Andre Russell", censusCSV[censusCSV.length-1].player);
        Assert.assertEquals(204.81, censusCSV[0].strikingrates,00);
    }

    @Test
    public void givenIPLRunsData_whenSortedByStrikeRate_ShouldReturnTopAverage() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.RUNS,IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.AVERAGE);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
        Assert.assertEquals(134.62, censusCSV[0].strikingrates,00);
    }


    @Test
    public void givenIPLRunsData_whenSortedByRuns_ShouldReturnTopAverage() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.RUNS,IPL_MOST_RUNS_CSV_FILE_PATH);
        String loadIplData = iplAnalyser.getSortedIPLData(SortedField.RUNS);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplData, IPLCricketDTO[].class);
        Assert.assertEquals("David Warner ", censusCSV[0].player);
    }

    @Test
    public void givenIplWicketsData_WhenSorted_ShouldReturnTopAverage() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.WICKETS,IPL_MOST_WICKETS_CSV_FILE_PATH);
        String loadIplwktsData = iplAnalyser.getSortedIPLData(SortedField.AVERAGE);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplwktsData, IPLCricketDTO[].class);
        Assert.assertEquals("Krishnappa Gowtham", censusCSV[0].player);

    }

    @Test
    public void givenIplWicketsData_WhenSorted_ShouldReturnTopStrikeRate() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.WICKETS,IPL_MOST_WICKETS_CSV_FILE_PATH);
        String loadIplwktsData = iplAnalyser.getSortedIPLData(SortedField.STRIKE_RATE);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplwktsData, IPLCricketDTO[].class);
        Assert.assertEquals("Krishnappa Gowtham", censusCSV[0].player);

    }

    @Test
    public void givenIplWicketsData_WhenSorted_ShouldReturnBestEconomyRate() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.WICKETS,IPL_MOST_WICKETS_CSV_FILE_PATH);
        String loadIplwktsData = iplAnalyser.getSortedIPLData(SortedField.ECONOMY);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplwktsData, IPLCricketDTO[].class);
        Assert.assertEquals("Ben Cutting", censusCSV[0].player);
    }

    @Test
    public void givenIplWicketsData_WhenSorted_ShouldReturnTopStrikingRateWith5WAnd4W() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplAnalyser = new IPLCricketAnalyser();
        iplAnalyser.loadIplData(IPLCricketAnalyser.CSVType.WICKETS,IPL_MOST_WICKETS_CSV_FILE_PATH);
        String loadIplwktsData = iplAnalyser.getSortedIPLData(SortedField.FIVE_FOUR);
        IPLCricketDTO[] censusCSV = new Gson().fromJson(loadIplwktsData, IPLCricketDTO[].class);
        Assert.assertEquals("Lasith Malinga", censusCSV[0].player);
    }


}
package com.cricketlegue;
import org.junit.Assert;
import org.junit.Test;

public class IPLCricketTest {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenIPLCricketData_WhenSortedOnBattingAverage_ReturnSortedData() throws IPLExceptionAnalyser {
        IPLCricketAnalyser iplCricketAnalyser = new IPLCricketAnalyser();
        int numOfRecords = iplCricketAnalyser.loadIplData(IPL_MOST_RUNS_CSV_FILE_PATH );
        Assert.assertEquals(101,numOfRecords);
    }
}

package com.cricketlegue;

import com.opencsv.bean.CsvBindByName;

public class IPLCricketRunCSV {
    @CsvBindByName(column = "PLAYER" ,required = true)
    public String player;

    @CsvBindByName(column = "Runs" , required = true)
    public int runs;

    public double getAverage() {
        return average;
    }

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "4s" ,required = true)
    public int  fours;

    @CsvBindByName(column = "6s" ,required = true)
    public int sixes;

    public double getStrikingrates() {
        return strikingrates;
    }

    @CsvBindByName(column = "SR", required = true)
    public double strikingrates;


    @Override
    public String toString() {
        return "IPLCricketRunCSV{" +
                "player='" + player + '\'' +
                ", runs=" + runs +
                ", average=" + average +
                ", fours=" + fours +
                ", sixs=" + sixes +
                ", strikingrates=" + strikingrates +
                '}';
    }


}

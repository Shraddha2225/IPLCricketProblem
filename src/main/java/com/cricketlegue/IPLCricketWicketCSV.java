package com.cricketlegue;
import com.opencsv.bean.CsvBindByName;
public class IPLCricketWicketCSV {

    @CsvBindByName(column = "PLAYER" , required = true)
    public String player;

    @CsvBindByName(column = "Runs" , required = true)
    public int runs;

    @CsvBindByName(column = "4w", required = true)
    public int four;

    @CsvBindByName(column = "5w", required = true)
    public int five;

    @CsvBindByName(column = "SR",required = true)
    public double strikingrates;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @Override
    public String toString() {
        return "IPLCricketWicketCSV{" +
                "player='" + player + '\'' +
                ", runs=" + runs +
                ", four=" + four +
                ", five=" + five +
                ", strikingrates=" + strikingrates +
                ", average=" + average +
                ", economy=" + economy +
                '}';
    }

    @CsvBindByName(column = "Econ", required = true)
    public double economy;


}

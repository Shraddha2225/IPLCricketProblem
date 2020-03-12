package com.cricketlegue;

public class IPLCricketDTO {
    public String player;
    public int runs;
    public double average;
    public int  fours;
    public int  sixs;
    public  int five;
    public double strikingrates;

    public IPLCricketDTO(IPLCricketRunCSV iplCricketDTO) {
        player = iplCricketDTO.player;
        runs = iplCricketDTO.runs;
        average = iplCricketDTO.average;
        fours = iplCricketDTO.fours;
        sixs = iplCricketDTO.sixes;
        strikingrates = iplCricketDTO.strikingrates;
    }

    public IPLCricketDTO(IPLCricketWicketCSV iplCricketWicketCSV) {
        player = iplCricketWicketCSV.player;
        runs = iplCricketWicketCSV.runs;
        fours=iplCricketWicketCSV.four;
        five =iplCricketWicketCSV.five;
        strikingrates=iplCricketWicketCSV.strikingrates;
        average=iplCricketWicketCSV.average;
    }
}

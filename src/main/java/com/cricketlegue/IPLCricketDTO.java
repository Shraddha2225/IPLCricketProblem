package com.cricketlegue;

import java.util.Comparator;

public class IPLCricketDTO {
    public String player;
    public int runs;
    public double average;
    public int  fours;
    public int  sixs;
    public double strikingrates;

    public IPLCricketDTO(IPLCricketRunCSV iplCricketDTO) {
        player = iplCricketDTO.player;
        runs = iplCricketDTO.runs;
        average = iplCricketDTO.average;
        fours = iplCricketDTO.fours;
        sixs = iplCricketDTO.sixs;
        strikingrates = iplCricketDTO.strikingrates;

    }

}

package com.cricketlegue;

import java.util.Comparator;

public class CompareFiveAndFour implements Comparator<IPLCricketDTO> {
    @Override
    public int compare(IPLCricketDTO dt1, IPLCricketDTO dt2) {
        return (dt1.fours+dt1.five) - (dt2.fours+dt2.five);
    }
}

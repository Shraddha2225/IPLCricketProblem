package com.cricketlegue;

import java.util.Comparator;

public class CompareSixAndFour implements Comparator<IPLCricketDTO> {
    @Override
    public int compare(IPLCricketDTO dt1, IPLCricketDTO dt2) {
        return (dt1.sixs+dt1.fours) - (dt2.sixs+dt2.fours);
    }
}

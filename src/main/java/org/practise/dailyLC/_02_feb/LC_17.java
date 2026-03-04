package org.practise.dailyLC._02_feb;

import java.util.ArrayList;
import java.util.List;

public class LC_17 {

//    401. Binary Watch
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hh = 0; hh <= 11; hh++) {
            for (int mm = 0; mm <= 59; mm++) {

                if (Integer.bitCount(hh) + Integer.bitCount(mm) == turnedOn) {
                    String hour = String.valueOf(hh);
                    String minute = (mm < 10 ? "0" : "") + mm;
                    result.add(hour + ":" + minute);
                }

            }
        }

        return result;
    }
}

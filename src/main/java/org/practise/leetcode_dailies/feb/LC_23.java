package org.practise.leetcode_dailies.feb;

import java.util.HashSet;

public class LC_23 {

    //    1461. Check If a String Contains All Binary Codes of Size K
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k)
            return false;
        int uniqueSub = 1 << k;
        HashSet<String> st = new HashSet<>();
        for (int i = k; i <= s.length(); i++) {
            String sub = s.substring(i - k, i);
            if (!st.contains(sub)) {
                st.add(sub);
                uniqueSub--;
            }
            if (uniqueSub == 0)
                return true;
        }
        return false;
    }
}
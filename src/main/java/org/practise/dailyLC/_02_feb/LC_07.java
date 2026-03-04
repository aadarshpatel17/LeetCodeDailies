package org.practise.dailyLC._02_feb;

import java.util.Stack;

public class LC_07 {

    // 1653. Minimum Deletions to Make String Balanced
    public int minimumDeletions(String s) {
        int n = s.length();
        int count = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && s.charAt(i) == 'a' && st.peek() == 'b') { //'ba'
                st.pop();
                count++;
            } else {
                st.push(s.charAt(i));
            }
        }

        return count;
    }

}

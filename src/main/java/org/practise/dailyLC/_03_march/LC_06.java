package org.practise.dailyLC._03_march;

public class LC_06 {

    // 1784. Check if Binary String Has at Most One Segment of Ones
    public boolean checkOnesSegment(String s) {
        boolean flag = false;
        int n = s.length();
        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i)== '1')
                flag = true;
            if(flag && s.charAt(i) == '0')
                return false;
        }
        return true;
    }

}

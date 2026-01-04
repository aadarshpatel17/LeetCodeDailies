package org.practise.random;

import javax.naming.CompositeName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersArray {

    public static ArrayList<Integer> findLeaders(ArrayList<Integer> elements, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(elements.get(i) > elements.get(j)) {
                    if(j == n-1) {
                        result.add(elements.get(i));
                    }
                } else {
                    break;
                }
            }
        }
        result.add(elements.get(n-1));
        return result;
    }

    public static ArrayList<Integer> findLeadersOptimize(ArrayList<Integer> elements, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxFromRight = elements.get(n-1);
        result.add(maxFromRight);
        for(int right=n-2; right>=0; right--) {
            if(maxFromRight < elements.get(right)) {
                maxFromRight = elements.get(right);
                result.add(maxFromRight);
            }
        }
        Collections.reverse(result);
        return result;
    }

}

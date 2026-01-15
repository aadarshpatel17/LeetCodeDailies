package org.practise.dsa_training.day8;

public class LC_2379 {

    // 2379. Minimum Recolors to Get K Consecutive Black Blocks
    public int minimumRecolors(String blocks, int k) {
        int min = 0, count = 0;
        // check how many we need to change in first k elements
        for(int i=0; i<k; i++) {
            if(blocks.charAt(i) != 'B') {
                count++;
            }
        }
        min = count;
        int left = 0, right = k;
        while(right < blocks.length()) {
            if(blocks.charAt(left) != 'B') {
                count--;
            }
            if(blocks.charAt(right) != 'B') {
                count++;
            }
            left++;
            right++;
            min = Math.min(count, min);
        }
        return min;
    }

}

package org.practise;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        input string
        String dna = input.next();
        int currMax = 1, max = 1;
        for(int i=0; i<dna.length()-1; i++) {
            if(dna.charAt(i) == dna.charAt(i+1)) {
                currMax++;
            } else {
                currMax = 1;
            }
            if(max < currMax) {
                max = currMax;
            }
        }
        System.out.println(max);
    }
}

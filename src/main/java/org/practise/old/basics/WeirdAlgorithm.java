package org.practise;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Long n = input.nextLong();
        System.out.print(n + " ");

        while(n != 1) {
            if(n < 1)
                break;
            if(n% 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }
            System.out.print(n + " ");
        }

    }
}

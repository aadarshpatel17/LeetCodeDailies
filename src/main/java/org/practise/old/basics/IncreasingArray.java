package basics.cses;

import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        variables
        long n = input.nextLong();
        long[] arr = new long[(int) n];
        long moves = 0;

//        inputs
        for(int i=0; i<n; i++)
            arr[i] = input.nextLong();

        for(int i=1; i<n; i++) {
            if(arr[i-1] > arr[i]) {
                moves += (arr[i-1] - arr[i]);
                arr[i] = arr[i-1];
            }
        }

/*
//        brute-force
        for(int i=0; i<n; i++)
            arr[i] = input.nextLong();

        for (int i = 1; i < n; i++) {
            if(arr[i-1] >= arr[i]) {
                while(arr[i-1] > arr[i]) {
                    arr[i]++;
                    moves++;
                }
            }
        }
*/
        System.out.println(moves);
    }
}

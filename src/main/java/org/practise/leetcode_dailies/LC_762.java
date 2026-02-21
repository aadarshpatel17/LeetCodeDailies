package org.practise.leetcode_dailies;

import java.util.Arrays;
import java.util.HashSet;

public class LC_762 {

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(10, 15));
        System.out.println(countPrimeSetBits_optimize(10, 15));
    }

    public static int countPrimeSetBits_optimize(int left, int right) {
        int result = 0;

        HashSet<Integer> primes = new HashSet<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

        for(int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);

            if(primes.contains(setBits)) {
                result++;
            }
        }

        return result;
    }

    // 762. Prime Number of Set Bits in Binary Representation
    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if(isPrimeII(countSetBits(i))) {
                count++;
            }
        }
        return count;
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeII(int num) {
        if(num <= 1) return false;
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }


}

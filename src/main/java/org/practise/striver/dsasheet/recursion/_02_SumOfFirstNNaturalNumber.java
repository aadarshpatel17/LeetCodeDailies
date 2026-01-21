package org.practise.striver.dsasheet.recursion;

public class _02_SumOfFirstNNaturalNumber {

//    Sum of first N Natural Numbers

    public static void main(String[] args) {
        _02_SumOfFirstNNaturalNumber a02BasicRecursion = new _02_SumOfFirstNNaturalNumber();

        int n = 10;
        System.out.println(a02BasicRecursion.sumOfFirstNNaturalNumber_bc(n));
        System.out.println(a02BasicRecursion.sumOfFirstNNaturalNumber_formula(n));
        System.out.println(a02BasicRecursion.sumOfFirstNNaturalNumber_recursion(n));
    }

    //    Sum of first N Natural Numbers
    // brute force:
    public int sumOfFirstNNaturalNumber_bc(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // using formula
    public int sumOfFirstNNaturalNumber_formula(int n) {
        return (n * (n + 1)) / 2;
    }

    public int sumOfFirstNNaturalNumber_recursion(int n) {
        if (n == 1) return 1;
        return n + sumOfFirstNNaturalNumber_recursion(n - 1);
    }

}

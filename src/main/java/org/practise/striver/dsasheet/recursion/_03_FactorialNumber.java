package org.practise.striver.dsasheet.recursion;

public class _03_FactorialNumber {

//    Factorial of a Number : Iterative and Recursive

    public static void main(String[] args) {
        _03_FactorialNumber a02BasicRecursion = new _03_FactorialNumber();

        int n = 5;
        System.out.println(a02BasicRecursion.factorial_BC(n));
        System.out.println(a02BasicRecursion.factorial_recursion(n));
    }

    // brute force
    public int factorial_BC(int n) {
        int fact = 1;
        for(int i=2; i<=n; i++) {
            fact *= i;
        }
        return fact;
    }

    // using recursion
    public int factorial_recursion(int n) {
        if(n == 0)
            return 1;
        return n * factorial_recursion(n-1);
    }

}

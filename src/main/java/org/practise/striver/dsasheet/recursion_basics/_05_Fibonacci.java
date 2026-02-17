package org.practise.striver.dsasheet.recursion_basics;

public class _05_Fibonacci {

//    Print Fibonacci Series up to Nth term

    public static void main(String[] args) {
        _05_Fibonacci a5_Fibonacci = new _05_Fibonacci();

        int n = 10;
//        System.out.println(Arrays.toString(a5_Fibonacci.fib_bc(n)));
        System.out.println(a5_Fibonacci.fib_recursion(n));
    }

    public int fib_recursion(int n) {
        if(n <= 1)
            return n;
        return fib_recursion(n - 1) + fib_recursion(n - 2);
    }

    public int[] fib_bc(int n) {
        if(n == 0) {
            return new int[]{0};
        }
        if(n == 1) {
            return new int[]{0, 1};
        }

        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2; i<=n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }

    public void fib_better(int n) {
        if(n == 0) {
            System.out.println(0);
            return;
        }
        if(n == 1) {
            System.out.println(0 + " " + 1);
            return;
        }

        int lastSecond = 0;
        int last = 1;
        int crt = 0;
        System.out.print(0 + " " + 1);
        for(int i=2; i<=n; i++) {
            crt = last + lastSecond;
            System.out.print(" " + crt);
            lastSecond = last;
            last = crt;
        }


    }

}

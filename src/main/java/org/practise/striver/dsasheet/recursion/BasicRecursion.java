package org.practise.striver.dsasheet.recursion;

public class BasicRecursion {

    public static void main(String[] args) {
        BasicRecursion basicRecursion = new BasicRecursion();

        int n = 10;

        // 1 to n
        basicRecursion.printNNumbers_ForwardRecursion(1, n);
        System.out.println();
        basicRecursion.printNNumbers_BackTracking(n, n);

        System.out.println();

        // n to 1
        basicRecursion.printNToOne_ForwardRecursion(n, n);
        System.out.println();
        basicRecursion.printNToOne_BackTracking(1, n);

    }

//    Print Name N times using Recursion
    public void printNameNTimes(int crt, int n) {
        if (crt > n) return;
        System.out.println("Leah Gotti");
        printNameNTimes(crt + 1, n);
    }

//    Print 1 to N using Recursion
    // forward recursion : 1 2 3 4 5 6 7 8 9 10
    public void printNNumbers_ForwardRecursion(int crt, int n) {
        if (crt > n) return;
        System.out.print(crt + " ");
        printNNumbers_ForwardRecursion(crt + 1, n);
    }

    // backtracking recursion: 1 2 3 4 5 6 7 8 9 10
    public void printNNumbers_BackTracking(int crt, int n) {
        if (crt < 1) return;
        printNNumbers_BackTracking(crt - 1, n);
        System.out.print(crt + " ");
    }

//    Print N to 1 using Recursion
    // 10 9 8 7 6 5 4 3 2 1
    public void printNToOne_ForwardRecursion(int crt, int n) {
        if(crt < 1) return;
        System.out.print(crt + " ");
        printNToOne_ForwardRecursion(crt - 1, n);
    }

    // 10 9 8 7 6 5 4 3 2 1
    public void printNToOne_BackTracking(int crt, int n) {
        if(crt > n) return;
        printNToOne_BackTracking(crt + 1, n);
        System.out.print(crt + " ");
    }

}

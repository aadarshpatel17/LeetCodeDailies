package org.practise.striver.dsasheet.pattern;

public class Patterns {

    // Pattern-1: Rectangular Star Pattern
    public void pattern1(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Pattern-2: Right-Angled Triangle Pattern
    public void pattern2(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Pattern - 3: Right-Angled Number Pyramid
    public void pattern3(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Pattern - 4: Right-Angled Number Pyramid - II
    public void pattern4(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    // Pattern-5: Inverted Right Pyramid
    public void pattern5(int n) {
        for(int i=n; i>=1; i--) {
            for(int j=i; j>=1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//    Pattern - 6: Inverted Numbered Right Pyramid
    public void pattern6(int n) {
        for(int i=n; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

//    Pattern - 7: Star Pyramid
    public void pattern7(int n) {
        for(int i=n; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}

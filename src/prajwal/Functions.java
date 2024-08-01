package prajwal;

import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        int b = in.nextInt();
//        int c = in.nextInt();
//        max(a,b,c);
//        min(a,b,c);

//        int n = in.nextInt();
//        evenOrOddBitAND(n);
//        evenOrOddBitOR(n);232232
//        evenOrOddBitXOR(n);
//        evenOrOddNaive(n);

//        System.out.println(isPrime(n));
//        System.out.println(isPrimeEfficient(n));

//        System.out.println(isPalindrome(n));

//        System.out.println(isPythagoreanTriplet(3,2,5));

        primeInRange(3, 59);
    }

    static void max(int a ,int b, int c){
        if (a>b && a>c)
            System.out.println(a);
        else if (b > c)
            System.out.println(b);
        else System.out.println(c);
    }

    static void min(int a, int b, int c){
        if (a<b && a<c)
            System.out.println(a);
        else if (b < c)
            System.out.println(b);
        else System.out.println(c);
    }

    static void evenOrOddNaive(int n){
        if (n%2 == 0)
            System.out.println("even");
        else System.out.println("odd");
    }
    static void evenOrOddBitOR(int n){
        if ((n | 1) > n){
            System.out.println("even");  // if bitwise or with 1 is greater than the given no. then it even
            // 1 1 0 0  = 12   1 0 1 1  = 11
            // 0 0 0 1         0 0 0 1
            //---------        -------
            // 1 1 0 1  = 13   1 0 1 1  = 11
        } else System.out.println("odd");
    }
    static void evenOrOddBitAND(int n){
        if ((n & 1) == 1){
            System.out.println("odd");  // if bitwise or with 1 is greater than the given no. then it even
            // 1 1 0 0  = 12   1 0 1 1  = 11
            // 0 0 0 1         0 0 0 1
            //---------        -------
            // 0 0 0 0         0 0 0 1
        } else System.out.println("even");
    }
    static void evenOrOddBitXOR(int n){
        if ((n ^ 1) == n+1){
            System.out.println("even");  // if bitwise or with 1 is greater than the given no. then it even
            // 1 1 0 0  = 12   1 0 1 1  = 11
            // 0 0 0 1         0 0 0 1
            //---------        -------
            // 1 1 0 1  = 13   1 0 1 0  = 10
        } else System.out.println("odd");
    }

    static boolean isPrime(int n){
        if (n <= 1) return false;

        int i = 2;
        while(i*i <= n){
            if(n%i == 0) return false;
            i++;
        }
        return true;
    }

    static boolean isPrimeEfficient(int n){
        if (n <= 1) return false;
        if(n==2 || n==3) return true;
        if (n%2 == 0 || n%3 == 0) return false;

        for (int i = 5; i*i <= n ; i+=6) {
            if (n%i == 0) return false;
        }
        return true;
    }

    static boolean isPalindrome(int n){
        int original = n;
        int rev = 0;
        while (n > 0){
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return rev == original;
    }

    static boolean isPythagoreanTriplet (int a, int b, int c){
        return a*a + b*b == c*c;
    }

    static void primeInRange(int a, int b){
        for (int i = a; i <= b; i++) {
            if (isPrimeEfficient(i))
                System.out.print(i + " ");
        }
    }
}

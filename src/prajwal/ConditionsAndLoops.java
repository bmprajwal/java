package prajwal;

   /*  1. Area Of Circle Java Program  - pi * radius * radius
       2. Area Of Triangle  -  0.5 * base * height
       3. Area Of Rectangle Program  -  length * breadth
       4. Area Of Isosceles Triangle   -  0.5 * base * height
       5. Area Of Parallelogram  -  base * height
       6. Area Of Rhombus  -  0.5 * diagonal1 * diagonal2
       7. Area Of Equilateral Triangle  -  sqrt(3)/4 * a^2
       8. Perimeter Of Circle  -  2 * pi * radius
       9. Perimeter Of Equilateral Triangle  3 * a
       10. Perimeter Of Parallelogram -  2 * (length + breadth)
       11. Perimeter Of Rectangle - 2 * (length + breadth)
       12. Perimeter Of Square  -  4 * side
       13. Perimeter Of Rhombus -  4 * side
       14. Volume Of Cone - 1/3 * pi * r*r * h
       15. Volume Of Prism  -  baseArea * height
       16. Volume Of Cylinder  -  pi * r*r * h
       17. Volume Of Sphere  -  4/3 * pi * r*r*r
       18. Volume Of Pyramid  -  baseLength * baseWidth * height / 3
       19. Curved Surface Area Of Cylinder  -  2 * pi * r * h
       20. Total Surface Area Of Cube  -  6 * side*side
       21. Fibonacci Series In Java Programs
       22. Subtract the Product and Sum of Digits of an Integer
      * 23. Input a number and print all the factors of that number (use loops).
      * 24. Take integer inputs till the user enters 0 and print the sum of all numbers (HINT: while loop)
      * 25. Take integer inputs till the user enters 0 and print the largest number from all.
       26. Addition Of Two Numbers


       * Factorial Program In Java
        Calculate Electricity Bill
        Calculate Average Of N Numbers
       * Calculate Discount Of Product
        Calculate Distance Between Two Points
        Calculate Commission Percentage
        Power In Java
       * Calculate Depreciation of Value
        Calculate Batting Average
        Calculate CGPA Java Program
       * Compound Interest Java Program
        Calculate Average Marks
        Sum Of N Numbers
        Armstrong Number In Java
        Find Ncr & Npr
       * Reverse A String In Java
        Find if a number is palindrome or not
        Future Investment Value
       * HCF Of Two Numbers Program
       * LCM Of Two Numbers
        Java Program Vowel Or Consonant
        Perfect Number In Java
        Check Leap Year Or Not
        Sum Of A Digits Of Number
        Kunal is allowed to go out with his friends only on the even days of a given month. Write a program to count the number of days he can go out in the month of August.
        Write a program to print the sum of negative numbers, sum of positive even numbers and the sum of positive odd numbers from a list of numbers (N) entered by the user. The list terminates when the user enters a zero.
*/

import java.util.Scanner;

public class ConditionsAndLoops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //22
//        System.out.println("Enter a number: ");
//        int n = in.nextInt();
//        int temp = n;
//        int digit = 0;
//        int sum = 0, product = 1;
//        while (temp > 0){
//            digit = temp % 10;
//            sum += digit;
//            product *= digit;
//            temp /= 10;
//        }
//        System.out.println("Product - Sum = " + (product - sum));

        //23
//        System.out.println("Enter a number: ");
//        int n = in.nextInt();
//        System.out.print("Factors of " + n + ": ");
//        for (int i = 1; i <= n ; i++) {
//            if (n % i == 0){
//                System.out.print(i + ", ");
//            }
//        }
//        System.out.println();

        //24
//        int n, max = 0;
//        do{
//            System.out.println("Enter a number: ");
//            n = in.nextInt();
//            if ( n > max)
//                max = n;
//
//        } while (n != 0);
//        System.out.println("Max: " + max);

        //27
//        System.out.println("Enter a number: ");
//        int n = in.nextInt();
//        int prod = 1;
//        for (int i = 1; i <= n; i++) {
//            prod *= i;
//        }
//        System.out.println(prod);

        //Discount
//        System.out.println("Enter principal amount: ");
//        int principal = in.nextInt();
//        System.out.println("Enter the discount percentage: ");
//        int disPercentage = in.nextInt();
//        float disAmount = (disPercentage / 100.0f) * principal;
//        System.out.println("Discount amount : " + disAmount);

        //Depreciation
//        System.out.println("Enter initial amount, depreciation rate, no. of years: ");
//        int initialAmount = in.nextInt();
//        int depRate = in.nextInt();
//        int years = in.nextInt();
//        double finalAmount = initialAmount * Math.pow(((100 - depRate)/100.0), years);
//        System.out.println("Final amount: " + finalAmount);

        //Compound Interest
//        System.out.println("Enter principal, rate, no. of times, years:  ");
//        int p = in.nextInt();
//        float r = in.nextFloat();
//        int n = in.nextInt();
//        int y = in.nextInt();
//        double a = p * Math.pow(1+(r/n), y);
//        System.out.println("After: " + a);


        //Reverse a string
//        System.out.println("Enter a string: ");
//        String str = in.next();
//        String rev = "";
//        int length = str.length();
//        for (int i = 0; i < length; i++) {
//            rev += str.charAt(length - 1 - i);
//        }
//        System.out.println(rev);

        //Hcf
//        System.out.println("Enter two no.s: ");
//        int a = in.nextInt();
//        int b = in.nextInt();
//        int max = Math.max(a,b);
//        int hcf = 1;
//        for (int i = 1; i < max; i++) {
//            if (a % i == 0 && b % i == 0)
//                hcf = i;
//        }
//        System.out.println("Hcf: " + hcf);

        //Lcm
        System.out.println("Enter two no.s: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int x = Math.max(a,b);
        int lcm = 0;
        while (x <= (a*b)){
            if (x % a == 0 && x % b == 0){
                lcm = x;
            }
            x++;
        }
        System.out.println("Lcm: " + lcm);

    }
}

package prajwal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Inputs {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
//        System.out.print("Enter your roll number: ");
//        int rollno = input.nextInt();
//        System.out.println("Your roll number is: " + rollno);

        // Celcius to Farenheit
//        System.out.print("Enter the temp is celcius: ");
//        float tempC = input.nextFloat();
//        float tempF = (tempC * 9/5) + 32;
//        System.out.println("Temperature in Farenheit: " + tempF);

        // Even or odd
//        System.out.print("enter a number: ");
//        int num = input.nextInt();
//        if(num % 2 == 0){
//            System.out.println("Even");
//        } else {
//            System.out.println("Odd");
//        }

        // Greeting message
//        System.out.print("Enter your name: ");
//        String name = input.next();
//        System.out.println("Have a nice year, " + name);

//        System.out.print("Enter the principal, time and rate: ");
//        float principal = input.nextFloat();
//        float time = input.nextFloat();
//        float rate = input.nextFloat();
//
//        float simpleInterest = (principal * time * rate) / 100;
//        System.out.println("Simple Interest: " + simpleInterest);

        // two numbers and operator
//        System.out.println("Enter two numbers and an operator: ");
//        int num1 = input.nextInt();
//        int num2 = input.nextInt();
//        char op = input.next().charAt(0);
//        if (op == '+'){
//            System.out.println("Addition of " + num1 + " and " + num2 + " is " + (num1+num2));
//        } else if (op == '-') {
//            System.out.println("Subtraction of " + num1 + " and " + num2 + " is " + (num1-num2));
//
//        }else if (op == '*') {
//            System.out.println("Multiplication of " + num1 + " and " + num2 + " is " + (num1*num2));
//
//        }else if (op == '/') {
//            System.out.println("Division of " + num1 + " and " + num2 + " is " + (num1/num2));
//
//        }else if (op == '%') {
//            System.out.println("Modulo of " + num1 + " and " + num2 + " is " + (num1%num2));
//
//        } else {
//            System.out.println("Invalid operator");
//        }

        // largest of two numbers
//        System.out.print("Enter two numbers: ");
//        int num1 = input.nextInt();
//        int num2 = input.nextInt();
//
//        if(num1 > num2){
//            System.out.println(num1 + " is largest.");
//        } else{
//            System.out.println(num2 + " is largest.");
//        }

        // rupees to usd
//        System.out.print("Enter currency is rupees: ");
//        float rupees = input.nextFloat();
//        float usd = rupees / 81.34f;
//        System.out.println(rupees + "rs in USD is " + usd);

        // Fibonacci numbers
//        int a = 0;
//        int b = 1;
//        System.out.print("To calculate nth Fibo no., enter the value of n: ");
//        int n = input.nextInt();
//
//        if (n == 0 || n == 1) {
//            System.out.println( n + "th fibo no. is " + n);
//            return;
//        }
//        int fibo = 0;
//        for (int i = 2; i <= n; i++){
//            fibo = a + b;
//            a = b;
//            b = fibo;
//        }
//        System.out.println(n + "th fibo no. is " + fibo);

        // Palindrome
//        System.out.println("Enter a String: ");
//        String s = input.next();
//        int length = s.length();
//        for (int i = 0; i < length / 2; i++) {
//            if (s.charAt(i) != s.charAt(length - 1 - i)){
//                System.out.println("not a palidrome");
//                return;
//            }
//        }
//        System.out.println("palindrome");

        // Palindrome number
//        System.out.println("Enter a number: ");
//        int num = input.nextInt();
//
//        int temp = num, rev = 0, digit;
//
//        while (temp > 0){
//            digit = temp % 10;
//            rev = rev * 10 + digit;
//            temp = temp / 10;
//        }
//
//        if (num == rev ){
//            System.out.println("Palindrome");
//        } else {
//            System.out.println("Not a palindrome");
//        }

        // Armstrong numbers between two numbers
//        System.out.print("Enter two numbers: ");
//        int num1 = input.nextInt();
//        int num2 = input.nextInt();
//        int digit = 0;
//
//        System.out.print("Armstrong numbers between " + num1 + " and " + num2 + " are: ");
//        for (int i = num1; i <= num2 ; i++) {
//            int temp = i;
//            int sum = 0;
//            while (temp > 0) {
//                digit = temp % 10;
//                sum += digit * digit * digit;
//                temp = temp / 10;
//            }
//            if (sum == i){
//                System.out.print(i + ", ");
//            }
//
//        }

//        BufferedReader read = new BufferedReader(InputStreamReader(System.in));

//        String s = "5";
//        char ch = 'a';
//        System.out.println(ch+1);

//        char ch = 'a';
//        switch (ch){
//
//            case 97 -> System.out.println("add");
//            default -> System.out.println("def");
//        }
        int a = 3;
        if (a++>3 || a == 4){
            System.out.println("Hi");
        }
    }
}

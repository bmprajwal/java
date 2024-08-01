package dsa.numberSystem;

public class EvenOdd {
    public static void main(String[] args) {
        System.out.println(isEven(10));

    }

    static boolean isEven(int n){
        return (n & 1) == 0;
    }
}

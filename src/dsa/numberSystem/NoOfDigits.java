package dsa.numberSystem;

public class NoOfDigits {
    public static void main(String[] args) {
        int a = 15;
        int b = 2;
        System.out.println(noOfDigits(a, b));
    }

    private static int noOfDigits(int a, int b) {
        return (int) (Math.log(a) / Math.log(b)) + 1;
    }
}

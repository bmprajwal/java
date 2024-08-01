package dsa.numberSystem;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2,5,4,3,4,9,3,5,2};
        System.out.println(ans(arr));
        System.out.println(ithBit(15, 3));
    }

    private static int ans(int[] arr) {
        int unique = 0;
        for(int a: arr){
            unique ^= a;
        }
        return unique;
    }

    static int ithBit(int no, int i){
        return (no & (1 << (i -1)));
    }
}

package dsa.arrays;

public class Frequencies {
    public static void main(String[] args) {
        int[] arr = {};
        freq(arr);
    }
    static void freq(int[] arr){
        int i = 0;
        int count = 0;
        while(i < arr.length){

            while(i + count < arr.length && arr[i] == arr[i+count]){
                count++;
            }
            System.out.println(arr[i] + " " + count);
            i += count;
            count = 0;
        }
    }
}

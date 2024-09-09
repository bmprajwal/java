package dsa.searchAlgo;

public class TernarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,8,10,11,12,19};
        System.out.println(ternarySearch(arr, 12));
    }
    static int ternarySearch(int[] arr, int key){
        int s = 0;
        int e = arr.length - 1;
        while(s <= e){
            int m1 = s + (e - s) / 3;
            int m2 = e - (e - s) / 3;

            if(key == arr[m1]){
                return m1;
            } else if(key == arr[m2]){
                return m2;
            } else if(key < arr[m1]){
                e = m1 -1;
            } else if(key > arr[m2]){
                s = m2 + 1;
            } else {
                s = m1 + 1;
                e = m2 - 1;
            }
        }
        return -1;
    }
}

package dsa.searchAlgo;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {4, 5, 38, 93, 54, 2, 87, 33};
        String str = "Prajwal";
        int target = 837;
        System.out.println(linearSearch3(str, 'j'));
    }

    static int linearSearch(int[] arr, int target){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    static boolean linearSearch2(int[] arr, int target){
        for (int j : arr) {
            if (j == target) {
                return true;
            }
        }
        return false;
    }

    static int linearSearch3(String str, char c){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c){
                return i;
            }
        }
        return -1;
    }
}

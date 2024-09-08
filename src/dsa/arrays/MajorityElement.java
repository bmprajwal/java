package dsa.arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 3, 4, 3, 3, 5};
        System.out.println(majorityElement(arr));
    }

    // Moore's Voting algorithm
    // https://medium.com/@veereshbk746/moores-voting-algorithm-b83114e12270
    static int majorityElement(int[] arr){
        int possible = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == possible){
                count++;
            } else {
                count--;
                if(count == 0){
                    possible = arr[i];
                    count = 1;
                }
            }
        }

        count = 0;
        for(int ele: arr){
            if(ele == possible){
                count++;
            }
        }
        return count > arr.length / 2? possible: -1;
    }
}

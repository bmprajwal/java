package dsa.recursion.arrays;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,49,29,291,5,57,91};
        int target = 5;
//        System.out.println(find(arr, target, 0));
//        System.out.println(find2(arr, target, 0));
//        System.out.println(findFromLast(arr, target, arr.length - 1));

        int[] arr1 = {1,3,5,23,6,3,59,3,29,2,3};
        System.out.println(findAllIndex3(arr1, 3, 0));


    }

    static int find(int[] arr, int target, int index){
        if(index > arr.length - 1){
            return -1;
        }
        if (arr[index] == target){
            return index;
        } else {
            return find(arr, target, index + 1);
        }
    }

    static boolean find2(int[] arr, int target, int index){
        if(index == arr.length){
            return false;
        }

        return arr[index] == target || find2(arr, target,index+1);
    }

    static int findFromLast(int[] arr, int target, int index){
        if(index == -1){
            return -1;
        }
        if (arr[index] == target){
            return index;
        } else {
            return findFromLast(arr, target, index - 1);
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return;
        }
        if (arr[index] == target){
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if (arr[index] == target){
            list.add(index);
        }
        return findAllIndex2(arr, target, index + 1, list);
    }


    // not advisable to use this approach

    static ArrayList<Integer> findAllIndex3(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if (arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndex3(arr, target, index + 1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}

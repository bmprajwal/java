package dsa.recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
//        subseq("", "abc");
//        System.out.println(subseq2("", "abcd"));
//        int[] arr = {1,2,3};
//        List<List<Integer>> ans = subset(arr);
//        for(List<Integer> list: ans){
//            System.out.println(list);
//        }
        int[] arr = {1,2,2};
        List<List<Integer>> ans = subsetDuplicate(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
    }

    static void subseq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subseq(p+ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    static ArrayList<String> subseq2(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subseq2(p+ch, up.substring(1));
        ArrayList<String> right = subseq2(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<Integer>());

        for(int num: arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> subsetDuplicate(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<Integer>());
        int start = 0;
        int end = 0;

        for(int i = 0; i < arr.length; i++){
            int n = outer.size();
            if(i > 0 &&arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = outer.size() - 1;
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}

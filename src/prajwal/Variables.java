package prajwal;

import java.util.*;
import java.util.stream.Collectors;

public class Variables {
    public static void main(String[] args) {
        // byte overflow
//        byte a = 126;
//        System.out.println(a);
//        a++;
//        System.out.println(a); //127
//        a++; // value overflows since byte can store only till 127
//        System.out.println(a); // -128
//        a++;
//        System.out.println(a); // -127


        //Integer caching
//        Integer i = 129;
//        Integer j = 129;
//        if(i == j){
//            System.out.println("same");
//        } else {
//            System.out.println("not same");
//        }
//    }

        // Integer and Double to byte
//        int i = 289;  // i % 256 => byte value
//        double d = 332.92;
//        byte b = (byte) i;
//        System.out.println(b);
//
//        b = (byte)d;
//        System.out.println(b);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(8,4,5,2,6,5));
        list.replaceAll(Variables::square);
        System.out.println(list);
        List<Integer> res = new ArrayList<>();
        Optional<Integer> first =  list.stream()
                .filter(x -> x > 10)
                .filter(x -> x % 2 == 0)
                .findFirst();
        res = list.stream()
                .filter(x -> x > 10)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(res);
        int min = list.stream().min(Comparator.naturalOrder()).get();
        System.out.println(min);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        System.out.println(Arrays.binarySearch(list.toArray(new Integer[0]), 4, Comparator.reverseOrder()));
        int[] arr = {1,2,3,4};
        System.out.println((float)(int) Arrays.stream(arr).filter(e -> e%2 ==0).count());
        Integer[] ar = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.stream(arr).average().getAsDouble());
}
static int square(int x) {
    return x*x;
}
}

package dsa.Heap;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(34);
        heap.insert(17);
        heap.insert(56);
        heap.insert(24);
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
        ArrayList<Integer> data = heap.heapSort();
        System.out.println(data);
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        q.add(34);
        q.add(17);
        q.add(56);
        q.add(24);
        q.add(78);
        while(!q.isEmpty()){
            System.out.print(q.poll() + " ");
        }
    }
}

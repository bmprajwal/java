package patterns;

import java.util.*;

public class Solution {

    public static int solution(List<Integer> arr, int src, int dest) {
        Map<Integer, Integer> visA = new HashMap<>();
        Map<Integer, Integer> visB = new HashMap<>();
        int start = arr.get(src);
        int curr = 1;
        Set<Integer> s = new HashSet<>();
        
        for (int x : arr) {
            s.add(x);
        }
        
        while (visA.getOrDefault(start, 0) == 0) {
            visA.put(start, curr);
            curr++;
            if (start == -1) {
                break;
            }
            start = arr.get(start);
        }
        
        start = arr.get(dest);
        while (visB.getOrDefault(start, 0) == 0) {
            visB.put(start, curr);
            curr++;
            if (start == -1) {
                break;
            }
            start = arr.get(start);
        }
        
        List<Pair> vp = new ArrayList<>();
        for (int x : s) {
            if (visA.getOrDefault(x, 0) != 0 && visB.getOrDefault(x, 0) != 0) {
                vp.add(new Pair(visA.get(x) + visB.get(x), x));
            }
        }
        
        vp.sort(Comparator.comparingInt(p -> p.sum));
        return vp.isEmpty() ? -1 : vp.get(0).node;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(scanner.nextInt());
            }
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int result = solution(arr, src, dest);
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
    
    static class Pair {
        int sum;
        int node;

        Pair(int sum, int node) {
            this.sum = sum;
            this.node = node;
        }
    }
}

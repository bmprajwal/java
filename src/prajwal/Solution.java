import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static int solution(List<Integer> arr) {
        int ans = Integer.MIN_VALUE;
        int result = -1;
        int[] weight = new int[arr.size()];
        Arrays.fill(weight, 0);

        for (int i = 0; i < arr.size(); i++) {
            int source = i;
            int dest = arr.get(i);
            if (dest != -1) {
                weight[dest] += source;
                if (ans <= weight[dest]) {
                    ans = Math.max(ans, weight[dest]);
                    result = dest;
                }
            }
        }

        if (ans != Integer.MIN_VALUE) {
            return result;
        }

        return -1;
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
            int result = solution(arr);
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
}

package prajwal;

import java.util.*;

public class TurnstileProblem {

    public static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
        int n = time.size();
        int[] result = new int[n];
        
        Queue<int[]> entryQueue = new LinkedList<>();
        Queue<int[]> exitQueue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (direction.get(i) == 0) {
                entryQueue.offer(new int[] {time.get(i), i});
            } else {
                exitQueue.offer(new int[] {time.get(i), i});
            }
        }
        
        int currentTime = 0;
        int lastUsedDirection = 1; // 0 for entry, 1 for exit (default to exit)

        while (!entryQueue.isEmpty() || !exitQueue.isEmpty()) {
            while (!entryQueue.isEmpty() && entryQueue.peek()[0] <= currentTime && !exitQueue.isEmpty() && exitQueue.peek()[0] <= currentTime) {
                if (lastUsedDirection == 1) {
                    int[] person = exitQueue.poll();
                    result[person[1]] = currentTime;
                } else {
                    int[] person = entryQueue.poll();
                    result[person[1]] = currentTime;
                }
            }
            
            while (!entryQueue.isEmpty() && entryQueue.peek()[0] <= currentTime) {
                int[] person = entryQueue.poll();
                result[person[1]] = currentTime;
                lastUsedDirection = 0;
                currentTime++;
            }
            
            while (!exitQueue.isEmpty() && exitQueue.peek()[0] <= currentTime) {
                int[] person = exitQueue.poll();
                result[person[1]] = currentTime;
                lastUsedDirection = 1;
                currentTime++;
            }
            
            if (!entryQueue.isEmpty() && !exitQueue.isEmpty() && entryQueue.peek()[0] > currentTime && exitQueue.peek()[0] > currentTime) {
                currentTime = Math.min(entryQueue.peek()[0], exitQueue.peek()[0]);
            } else if (!entryQueue.isEmpty() && entryQueue.peek()[0] > currentTime) {
                currentTime = entryQueue.peek()[0];
            } else if (!exitQueue.isEmpty() && exitQueue.peek()[0] > currentTime) {
                currentTime = exitQueue.peek()[0];
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int r : result) {
            resultList.add(r);
        }

        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> time = Arrays.asList(0, 0, 1, 5);
        List<Integer> direction = Arrays.asList(0, 1, 1, 0);
        System.out.println(getTimes(time, direction));  // Example usage
    }
}

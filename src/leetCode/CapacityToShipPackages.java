package leetCode;

public class CapacityToShipPackages {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        System.out.println(shipWithinDays(weights, days));
    }
    static int shipWithinDays(int[] weights, int days){
        int start = 0;
        int end = 0;

        for(int num : weights){
            start = Math.max(start, num);
            end += num;
        }

        while (start < end){
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;
            for(int weight : weights){
                if(sum + weight > mid){
                    pieces++;
                    sum = weight;
                } else {
                    sum += weight;
                }
            }

            if(pieces <= days){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}

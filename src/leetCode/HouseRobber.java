package leetCode;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1) pick+=prev2;

            int notpick=prev;
            int curr=Math.max(pick, notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}

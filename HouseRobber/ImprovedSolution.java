public class ImprovedSolution {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        
        int taken = 0, notTaken = 0, temp = 0;
        for(int i = 0; i < nums.length; ++i) {
            temp = taken;
            taken = notTaken + nums[i];
            notTaken = Math.max(temp, notTaken);
        }
        
        return Math.max(taken, notTaken);
    }
}

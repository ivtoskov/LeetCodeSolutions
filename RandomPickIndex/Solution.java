public class Solution {
    private Map<Integer, ArrayList<Integer>> indices;
    private Random rand;
    
    public Solution(int[] nums) {
        indices = new HashMap<>();
        rand = new Random();
        for (int i = 0; i < nums.length; ++i) {
            indices.putIfAbsent(nums[i], new ArrayList<>());
            indices.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        if (indices.containsKey(target)) {
            List<Integer> targetIndices = indices.get(target);
            return targetIndices.get(rand.nextInt(targetIndices.size()));
        }
        return -1; // TODO
    }
}

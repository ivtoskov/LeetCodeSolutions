public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }
    
    private List<List<Integer>> permute(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if(index >= nums.length) {
            List<Integer> empty = new ArrayList<>();
            result.add(empty);
            return result;
        }
        List<List<Integer>> prev = permute(nums, index + 1);
        int current = nums[index];
        for(List<Integer> p: prev) {
            p.add(0, current);
            List<Integer> cur = p;
            result.add(cur);
            for(int i = 1; i < p.size(); ++i) {
                List<Integer> n = new ArrayList<>(cur);
                int temp = n.get(i - 1);
                n.set(i - 1, n.get(i));
                n.set(i, temp);
                cur = n;
                result.add(cur);
            }
        }
        return result;
    }
}

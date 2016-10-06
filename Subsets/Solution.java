public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }
    
    private List<List<Integer>> subsets(int[] nums, int index) {
        if (index >= nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        
        List<List<Integer>> prevLists = subsets(nums, index + 1);
        List<List<Integer>> moreLists = new ArrayList<>(prevLists);
        for (List<Integer> prev : prevLists) {
            List<Integer> newList = new ArrayList(prev);
            newList.add(nums[index]);
            moreLists.add(newList);
        }
        
        return moreLists;
    }
}

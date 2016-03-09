public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if(nums == null || nums.length == 0) return ranges;
        int start = 0;
        for(int end = 1; end < nums.length; ++end) {
            while(end < nums.length && nums[end] == nums[end - 1] + 1) ++end;
            ranges.add(nums[start] + ((start != end - 1) ? ("->" + nums[end - 1]) : ""));
            start = end;
        }
        if(start < nums.length) {
            ranges.add(nums[start] + ((start != nums.length - 1) ? ("->" + nums[nums.length - 1]) : ""));
        }
        return ranges;
    }
}

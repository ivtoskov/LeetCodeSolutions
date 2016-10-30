public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (arr1, arr2) -> nums1[arr1[0]] + nums2[arr1[1]] - nums1[arr2[0]] - nums2[arr2[1]]);
        queue.add(new int[]{0, 0});
        
        while (!queue.isEmpty() && k-- > 0) {
            int[] cur = queue.poll();
            result.add(new int[]{nums1[cur[0]], nums2[cur[1]]});
            if (cur[1] + 1 < nums2.length) {
                queue.add(new int[]{cur[0], cur[1] + 1});
            }
            if (cur[1] == 0 && cur[0] + 1 < nums1.length) {
                queue.add(new int[]{cur[0] + 1, cur[1]});
            }
        }
        
        return result;
    }
}

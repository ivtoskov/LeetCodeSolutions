public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums1) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int num: nums2) {
            if(map.containsKey(num)) {
                Integer cur = map.get(num);
                if(cur > 0) {
                    res.add(num);
                    map.put(num, cur - 1);
                }
            }
        }
        
        int[] result = new int[res.size()];
        int index = 0;
        for(int num: res) {
            result[index++] = num;
        }
        return result;
    }
}

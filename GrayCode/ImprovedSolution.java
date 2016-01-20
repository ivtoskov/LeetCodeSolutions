public class Solution {
    public List<Integer> grayCode(int n) {
        // Initialize arraylist
        List<Integer> codes = new ArrayList<>();
        codes.add(0, 0);
        
        // Compute recursively
        for(int i = 0; i < n; ++i) {
            int mask = (1 << i);
            for(int j = codes.size() - 1; j >= 0; --j) {
                codes.add(mask | codes.get(j));
            }
        }
        
        return codes;
    }
}

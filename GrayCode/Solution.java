public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> codes = new ArrayList<>((int)Math.pow(2, n));
        codes.add(0, 0);
        if(n == 0) {
            return codes;
        }
        
        for(int i = 0, index = 1; i < n; ++i) {
            int mask = (1 << i);
            for(int j = index - 1; j >= 0; --j) {
                codes.add(index++, mask | codes.get(j));
            }
        }
        
        return codes;
    }
}

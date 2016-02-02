public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        generate(result, new ArrayList<>(), 1, k, n);
        return result;
    }
    
    private void generate(List<List<Integer>> result, List<Integer> current, int start, int k, int n) {
        if(k == 0 && n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = start; i < 10; ++i) {
            current.add(i);
            generate(result, current, i + 1, k - 1, n - i);
            current.remove(current.size() - 1);
        }
    }
}

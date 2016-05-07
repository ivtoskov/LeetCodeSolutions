public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combine(result, path, 1, n, k);
        return result;
    }
    
    public void combine(List<List<Integer>> result, List<Integer> path, int m, int n, int k) {
        if(k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = m; i <= n; ++i) {
            path.add(i);
            combine(result, path, i + 1, n, k - 1);
            path.remove(path.size() - 1);
        }
    }    
}

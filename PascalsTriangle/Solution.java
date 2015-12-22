public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        if(numRows >= 1) {
            List<Integer> first = new ArrayList<>();
            first.add(1);
            answer.add(first);
        }
        generate(answer, 1, numRows);
        return answer;
    }
    
    private void generate(List<List<Integer>> prev, int index, int limit) {
        if(index >= limit) return;
        List<Integer> last = prev.get(prev.size() - 1);
        List<Integer> current = new ArrayList<>();
        current.add(1);
        for(int i = 1; i < index; ++i) {
            int n = last.get(i-1) + last.get(i);
            current.add(n);
        }
        current.add(1);
        prev.add(current);
        generate(prev, index + 1, limit);
    }
}

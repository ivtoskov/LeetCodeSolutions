public class Solution {
    private static final String BASE = "()";

    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(generateParanthesis(n));
    }
    
    private Set<String> generateParanthesis(int n) {
        Set<String> answer = new HashSet<>();
        if(n == 1) {
            answer.add(BASE);
        } else {
            Set<String> prev = generateParanthesis(n - 1);
            for(String s: prev) {
                for(int i = 0; i < s.length(); ++i) {
                    answer.add(s.substring(0, i) + BASE + s.substring(i, s.length()));
                }
            }
        }
        return answer;
    }
}

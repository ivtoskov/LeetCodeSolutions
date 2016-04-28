public class Solution {
    private List<Integer>[][] dp;
    private List<Integer> numbers;
    private List<Character> operations;
    private int n;
    
    public List<Integer> diffWaysToCompute(String input) {
        numbers = new ArrayList<>();
        operations = new ArrayList<>();
        n = input.length();
        for(int i = 0; i < n; ++i) {
            int current = 0;
            while(i < n && Character.isDigit(input.charAt(i))) {
                current = current * 10 + input.charAt(i) - '0';
                ++i;
            }
            numbers.add(current);
            if(i < n) {
                operations.add(input.charAt(i));
            }
        }
        
        n = numbers.size();
        if(n == 1) {
            return numbers;
        }
        dp = new List[n][n];
        for(int i = 0; i < n - 1; ++i) {
            dp[i][i] = new ArrayList<>();
            dp[i][i].add(numbers.get(i));
            dp[i][i + 1] = new ArrayList<>();
            switch(operations.get(i)) {
                case '*':
                    dp[i][i + 1].add(numbers.get(i) * numbers.get(i + 1));
                    break;
                case '+':
                    dp[i][i + 1].add(numbers.get(i) + numbers.get(i + 1));
                    break;
                default:
                    dp[i][i + 1].add(numbers.get(i) - numbers.get(i + 1));
                    break;
            }
        }
        dp[n-1][n-1] = new ArrayList<>();
        dp[n-1][n-1].add(numbers.get(n-1));
        
        return diffWaysToCompute(0, n - 1);
    }
    
    private List<Integer> diffWaysToCompute(int start, int end) {
        if(dp[start][end] != null) {
            return dp[start][end];
        }
        List<Integer> result = new ArrayList<>(), left, right;
        for(int i = start; i < end; ++i) {
            left = dp[start][i] == null ? diffWaysToCompute(start, i) : dp[start][i];
            right = dp[i + 1][end] == null ? diffWaysToCompute(i + 1, end) : dp[i + 1][end];
            
            for(Integer leftParam: left) {
                for(Integer rightParam: right) {
                    switch(operations.get(i)) {
                        case '*':
                            result.add(leftParam * rightParam);
                            break;
                        case '+':
                            result.add(leftParam + rightParam);
                            break;
                        default:
                            result.add(leftParam - rightParam);
                            break;
                    }
                }
            }
        }
        
        dp[start][end] = result;
        return dp[start][end];
    }
}

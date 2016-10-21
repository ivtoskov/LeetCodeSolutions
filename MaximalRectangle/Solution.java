public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for (char[] row : matrix) {
            updateHeights(row, heights);
            max = Math.max(max, largestRectangleArea(heights));
        }
        
        return max;
    }
    
    private void updateHeights(char[] row, int[] heights) {
        for (int i = 0; i < row.length; ++i) {
            int val = row[i] - '0';
            heights[i] = (val + heights[i]) * val;
        }
    }
    
    private int largestRectangleArea(int[] heights) {
        int best = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= heights.length; ) {
            int current = (i == heights.length) ? 0 : heights[i];
            
            if (stack.isEmpty() || current >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                best = Math.max(best, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }
        
        return best;
    }
}

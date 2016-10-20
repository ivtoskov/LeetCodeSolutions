public class Solution {
    public int largestRectangleArea(int[] heights) {
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

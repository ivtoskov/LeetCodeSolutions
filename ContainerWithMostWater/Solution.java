public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxx = 0, leftMax, rightMax;
        while(i < j) {
            leftMax = height[i];
            rightMax = height[j];
            maxx = Math.max(maxx, (j - i) * Math.min(leftMax, rightMax));
            
            if(leftMax < rightMax) {
                while(i < j && height[i] <= leftMax) ++i;
            } else {
                while(i < j && height[j] <= rightMax) --j;
			   }
        }
        return maxx;
    }
}

public class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for(int i: nums) {
            colors[i]++;
        }
        int index = 0;
        for(int i = 0; i < colors.length; ++i) {
            while(colors[i] > 0) {
                nums[index++] = i;
                colors[i]--;
            }
        }
    }
}

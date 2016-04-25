public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int upperBound = 0, lowerBound = n - 1, leftBound = 0, rightBound = n - 1, num = 1;
        while(upperBound <= lowerBound) {
            for(int i = upperBound, j = leftBound; result[i][j] == 0; ++num) {
                result[i][j] = num;
                if(i == upperBound && j < rightBound) {
                    ++j;
                }
                else if(i < lowerBound && j == rightBound) ++i;
                else if(i == lowerBound && j > leftBound) --j;
                else if(i > upperBound) --i;
            }
            
            ++upperBound;
            --lowerBound;
            ++leftBound;
            --rightBound;
        }
        
        return result;
    }
}

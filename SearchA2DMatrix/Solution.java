public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n, column = mid % n;
            if(matrix[row][column] == target) {
                return true;
            }
            if(matrix[row][column] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

/**
 * Write an efficient algorithm that searches for a value target in 
 * an m x n integer matrix matrix. This matrix has the following 
 * properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer 
 * of the previous row.
 * 
 * leetcode:
 * https://leetcode.com/problems/search-a-2d-matrix/
*/

public class SearchInSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return matrix[start / n][start % n] == target || matrix[end / n][end % n] == target;
    }
}
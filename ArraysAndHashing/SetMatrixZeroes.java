package ArraysAndHashing;

/*
Problem:
Given an m x n integer matrix, if an element is 0,
set its entire row and column to 0.

You must do it in-place.

Approach:
1. Use first row and first column as markers.
2. If matrix[i][j] == 0:
      - mark row using matrix[i][0]
      - mark column using matrix[0][j]
3. Traverse again and convert cells to 0 using markers.
4. Finally handle first row and first column separately.

Why first row/column separately?
Because they are being used as marker arrays,
so we must preserve their original zero state.

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        // Total number of rows
        int rows = matrix.length;

        // Total number of columns
        int cols = matrix[0].length;

        // Check whether first row originally contains zero
        boolean firstRowZero = false;

        // Check whether first column originally contains zero
        boolean firstColZero = false;

        // Step 1:
        // Check first row for any zero
        for (int j = 0; j < cols; j++) {

            if (matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }

        // Step 2:
        // Check first column for any zero
        for (int i = 0; i < rows; i++) {

            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        // Step 3:
        // Use first row and column as markers
        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                // If current cell is zero
                if (matrix[i][j] == 0) {

                    // Mark corresponding row
                    matrix[i][0] = 0;

                    // Mark corresponding column
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4:
        // Convert cells to zero using markers
        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                // If row OR column is marked
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5:
        // Handle first row separately
        if (firstRowZero) {

            for (int j = 0; j < cols; j++) {

                matrix[0][j] = 0;
            }
        }

        // Step 6:
        // Handle first column separately
        if (firstColZero) {

            for (int i = 0; i < rows; i++) {

                matrix[i][0] = 0;
            }
        }
    }
}
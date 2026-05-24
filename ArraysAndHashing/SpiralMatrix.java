package ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

/*
Problem:
Given an m x n matrix, return all elements
of the matrix in spiral order.

Example:
Input:
[
 [1, 2, 3, 4],
 [5, 6, 7, 8],
 [9,10,11,12]
]

Output:
[1,2,3,4,8,12,11,10,9,5,6,7]

Approach:
Use four boundaries:

1. top    -> starting row
2. bottom -> ending row
3. left   -> starting column
4. right  -> ending column

Traverse in 4 directions:
1. Left -> Right
2. Top -> Bottom
3. Right -> Left
4. Bottom -> Top

After every traversal,
move the corresponding boundary inward.

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        // Top row boundary
        int top = 0;

        // Bottom row boundary
        int bottom = matrix.length - 1;

        // Left column boundary
        int left = 0;

        // Right column boundary
        int right = matrix[0].length - 1;

        // Stores spiral traversal result
        List<Integer> result = new ArrayList<>();

        // Continue until boundaries cross
        while (top <= bottom && left <= right) {

            // Step 1:
            // Traverse left -> right
            for (int i = left; i <= right; i++) {

                result.add(matrix[top][i]);
            }

            // Move top boundary downward
            top++;

            // Step 2:
            // Traverse top -> bottom
            for (int i = top; i <= bottom; i++) {

                result.add(matrix[i][right]);
            }

            // Move right boundary leftward
            right--;

            // Step 3:
            // Traverse right -> left
            if (top <= bottom) {

                for (int i = right; i >= left; i--) {

                    result.add(matrix[bottom][i]);
                }

                // Move bottom boundary upward
                bottom--;
            }

            // Step 4:
            // Traverse bottom -> top
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {

                    result.add(matrix[i][left]);
                }

                // Move left boundary rightward
                left++;
            }
        }

        return result;
    }

    // Driver Code
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        SpiralMatrix obj = new SpiralMatrix();

        List<Integer> result = obj.spiralOrder(matrix);

        System.out.println(result);
    }
}
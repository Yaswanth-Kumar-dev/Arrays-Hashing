package ArraysAndHashing;

/*
Problem:
Determine if Sudoku board is valid.

Approach:
Track rows, columns, and boxes using boolean arrays.

Time Complexity: O(1)
Space Complexity: O(1)
*/

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {
                    continue;
                }

                int val = board[r][c] - '1';
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (row[r][val] || col[c][val] || box[boxIndex][val]) {
                    return false;
                }

                row[r][val] = true;
                col[c][val] = true;
                box[boxIndex][val] = true;
            }
        }

        return true;
    }
}
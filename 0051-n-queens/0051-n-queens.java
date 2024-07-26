class Solution {
  public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        // Step 1: Initialize the board with empty spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // Step 2: Start backtracking from the first row
        solve(solutions, board, 0, n);
        return solutions;
    }

    // Recursive backtracking function
    private static void solve(List<List<String>> solutions, char[][] board, int row, int n) {
        // Step 5: If we've placed queens in all rows, add the solution
        if (row == n) {
            solutions.add(construct(board));
            return;
        }

        // Step 3: Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q'; // Place queen
                solve(solutions, board, row + 1, n); // Move to the next row
                board[row][col] = '.'; // Backtrack (remove queen)
            }
        }
    }

    // Check if it's safe to place a queen at board[row][col]
    private static boolean isValid(char[][] board, int row, int col, int n) {
        // Step 4: Check the column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the diagonal (top-left to bottom-right)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the diagonal (top-right to bottom-left)
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Construct the board configuration for the solution
    private static List<String> construct(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solution.add(new String(board[i]));
        }
        return solution;
    }

}
class Solution {


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize the board with empty spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // Start backtracking from the first row
        solve(board, n, 0, solutions);
        return solutions;
    }

    private static void solve(char[][] board, int n, int row, List<List<String>> solutions) {
        // If we've placed queens in all rows, add the solution
        if (row == n) {
            solutions.add(construct(board));
            return;
        }
        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q'; // Place queen
                solve(board, n, row + 1, solutions); // Move to the next row
                board[row][col] = '.'; // Backtrack (remove queen)
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col, int n) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the diagonal (top-left to bottom-right)
        for (int r = row - 1, j = col - 1; r >= 0 && j >= 0; r--, j--) {
            if (board[r][j] == 'Q') {
                return false;
            }
        }

        // Check the diagonal (top-right to bottom-left)
        for (int r = row - 1, j = col + 1; r >= 0 && j < n; r--, j++) {
            if (board[r][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solution.add(new String(board[i]));
        }
        return solution;
    }
}


import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};
        int numOfRows = heightMap.length;
        int numOfCols = heightMap[0].length;
        boolean[][] visited = new boolean[numOfRows][numOfCols];
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        int totalWaterVolume = 0;

        // Add all boundary cells to the priority queue
        for (int r = 0; r < numOfRows; r++) {
            for (int c = 0; c < numOfCols; c++) {
                if (r == 0 || c == 0 || r == numOfRows - 1 || c == numOfCols - 1) {
                    pq.offer(new Cell(heightMap[r][c], r, c));
                    visited[r][c] = true;
                }
            }
        }

        // Process cells
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int currRow = cell.row;
            int currCol = cell.col;
            int height = cell.height;

            for (int i = 0; i < 4; i++) {
                int neighbourRow = currRow + dRow[i];
                int neighbourCol = currCol + dCol[i];

                if (isValidCell(neighbourRow, neighbourCol, numOfRows, numOfCols) &&
                        !visited[neighbourRow][neighbourCol]) {
                    visited[neighbourRow][neighbourCol] = true;
                    int neighbourHeight = heightMap[neighbourRow][neighbourCol];
                    if (neighbourHeight < height) {
                        totalWaterVolume += height - neighbourHeight;
                    }
                    pq.offer(new Cell(Math.max(neighbourHeight, height), neighbourRow, neighbourCol));
                }
            }
        }

        return totalWaterVolume;
    }

    private static class Cell implements Comparable<Cell> {
        int height;
        int row;
        int col;

        public Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Cell other) {
            // Min-heap comparison
            return Integer.compare(this.height, other.height);
        }
    }

    private boolean isValidCell(int row, int col, int numOfRows, int numOfCols) {
        return row >= 0 && col >= 0 && row < numOfRows && col < numOfCols;
    }
}

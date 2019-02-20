public class LargestAreaOfEnemyCells {
    public static final int[][] Directions =
            {
                    new int[]{1, 0},
                    new int[]{-1, 0},
                    new int[]{0, 1},
                    new int[]{0, -1},
            };

    public static void main(String[] args) {
        boolean[][] maze = new boolean[10][10];
        PopulateMaze(maze);

        System.out.println((FindLargestPath(maze)));
    }

    public static void PopulateMaze(boolean[][] maze) {
        maze[0][3] = true;
        maze[1][3] = true;
        maze[2][3] = true;

        for (int col = 0; col <= 3; col++) {
            maze[3][col] = true;
        }
    }

    public static int FindLargestPath(boolean[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int maxCount = 0;

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                if (!visited[row][col]) {
                    int currentCount = 0;

                    CountAdjacentCells(maze, visited, row, col, currentCount);

                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                    }
                }
            }
        }

        return maxCount;
    }

    private static void CountAdjacentCells(boolean[][] maze, boolean[][] visited, int row, int col, int count) {
        if (!IsInRange(row, col, maze.length, maze[0].length)) {
            return;
        }

        if (visited[row][col]) {
            return;
        }

        if (maze[row][col]) {
            return;
        }

        ++count;
        visited[row][col] = true;

        for (int[] direction : Directions) {
            CountAdjacentCells(maze, visited, row + direction[0], col + direction[1], count);
        }
    }

    private static boolean IsInRange(int row, int col, int rows, int cols) {
        boolean rowIsInRange = row >= 0 && row < rows;
        boolean colIsInRange = col >= 0 && col < cols;

        return rowIsInRange && colIsInRange;
    }

}

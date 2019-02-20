package dsa;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};

        int result = islandPerimeter(matrix);
        System.out.println(result);
    }

    public static int islandPerimeter(int[][] grid) {
        int counter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (checkIfOutside(i - 1, j, grid.length, grid[0].length) || grid[i - 1][j] == 0) {
                        counter++;
                    }
                    if (checkIfOutside(i, j - 1, grid.length, grid[0].length) || grid[i][j - 1] == 0) {
                        counter++;
                    }
                    if (checkIfOutside(i + 1, j, grid.length, grid[0].length) || grid[i + 1][j] == 0) {
                        counter++;
                    }
                    if (checkIfOutside(i, j + 1, grid.length, grid[0].length) || grid[i][j + 1] == 0) {
                        counter++;
                    }
                }

            }
        }

        return counter;

    }

    public static boolean checkIfOutside(int row, int col, int gridRowLength, int gridColLength) {
        if (row < 0 || row >= gridRowLength || col < 0 || col >= gridColLength) {
            return true;
        }
        return false;
    }
}

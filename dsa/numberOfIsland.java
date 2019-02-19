import java.util.HashSet;
import java.util.Set;

 class NumberOfIslands
{
    public static int numIslands(char[][] grid)
    {
        Set<String> visited = new HashSet<>();

        int count = 0;

        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[row].length; col++)
            {
                if (grid[row][col] == '0' || visited.contains(row + ";" + col))
                    continue;

                ++count;
                visited.add(row + ";" + col);

                dfs(row, col, grid, visited);
            }
        }

        return count;
    }

    private static void dfs(int row, int col, char[][] grid, Set<String> visited)
    {
        int[] dRows = {0, -1, 0, +1};
        int[] dCols = {-1, 0, +1, 0};

        visited.add(row + ";" + col);

        for (int dir = 0; dir < dRows.length; dir++)
        {
            int nextRow = row + dRows[dir];
            int nextCol = col + dCols[dir];

            if (nextRow < 0 || nextRow >= grid.length ||
                    nextCol < 0 || nextCol >= grid[0].length)
                continue;

            String code = nextRow + ";" + nextCol;

            if (visited.contains(nextRow + ";" + nextCol))
                continue;

            visited.add(code);
            dfs(nextRow, nextCol, grid, visited);
        }
    }

    public static void main(String[] args)
    {
        char[][] grid =
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'},
                };

        System.out.println(numIslands(grid));
    }
}
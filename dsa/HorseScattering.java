import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class HorseScattering {

    private static int[] rows = {2, 2, 1, 1, -1, -1, -2, -2};
    private static int[] cols = {-1, 1, 2, -2, -2, 2, -1, 1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int r = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[n][m];
        matrix[r][c] = 1;
        visited = new boolean[n][m];
        visited[r][c] = true;
        bfs(matrix, r, c);
        int colToBePrinted = m / 2;
        for (int[] row : matrix) {
            System.out.println(row[colToBePrinted]);
        }
    }

    private static void bfs(int[][] matrix, int row, int col) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        Integer[] position = {row, col};
        queue.offer(position);

        while (!queue.isEmpty()) {
            Integer[] currentPosition = queue.poll();
            row = currentPosition[0];
            col = currentPosition[1];

            for (int i = 0; i < rows.length; i++) {
                int currRow = row + rows[i];
                int currCol = col + cols[i];

                if (currRow < 0 || currRow >= matrix.length || currCol < 0 || currCol >= matrix[0].length ||
                        visited[currRow][currCol]) {
                    continue;
                }


                Integer[] newPosition = {currRow, currCol};
                queue.offer(newPosition);
                matrix[currRow][currCol] = matrix[row][col] + 1;
                visited[currRow][currCol] = true;
            }
        }
    }
}
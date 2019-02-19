
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

 class bikeDmgWithDFS {
    public static double bestPath = 99999.00;
    public static double[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(in.readLine());
        int cols = Integer.parseInt(in.readLine());
        matrix = new double[rows][cols];
        for(int row = 0; row < rows; row++) {
            String[] line = in.readLine().split(" ");
            for(int col = 0; col < cols; col++) {
                matrix[row][col] = Double.parseDouble(line[col]);
            }
        }
        dfs(0, 0, 0, 0, matrix[0][0]);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(bestPath));
    }

    public static void dfs(int row, int col, int prevRow, int prevCol, double path) {
        if(row == matrix.length - 1 && col == matrix[matrix.length - 1].length - 1) {
            path += Math.max(matrix[prevRow][prevCol], matrix[row][col]) - Math.min(matrix[prevRow][prevCol], matrix[row][col]);
            path += matrix[row][col];
            if(path < bestPath) {
                bestPath = path;
            }
        }

        path += Math.max(matrix[prevRow][prevCol], matrix[row][col]) - Math.min(matrix[prevRow][prevCol], matrix[row][col]);

        if(col + 1 < matrix[row].length) {
            dfs(row, col + 1, row, col, path);
        }
        if(row + 1 < matrix.length) {
            dfs(row + 1, col, row, col, path);
        }
        if(row + 1 < matrix.length && col + 1 < matrix[row + 1].length) {
            dfs(row + 1, col + 1, row, col, path);
        }
        if(row + 1 < matrix.length && col - 1 >= 0) {
            dfs(row + 1, col - 1, row, col, path);
        }
    }
}
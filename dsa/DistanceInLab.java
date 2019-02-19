package dsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceInLab {

    private static class Point {
        private int row;
        private int col;

        private Point() {
        }

        private Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(input.readLine());
        int[][] matrix = new int[size][size];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            String line = input.readLine();
            for (int j = 0; j < line.length(); j++) {
                int index = line.charAt(j) == '*' ? -1 : line.charAt(j) == 'x' ? -2 : 0;
                matrix[i][j] = line.charAt(j) == '*' ? -1 : line.charAt(j) == 'x' ? -2 : 0;
                if (matrix[i][j] == -1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        Point point = queue.poll();
        int row = point.row;
        int col = point.col;
        matrix[point.row][point.col] = 0;
        queue.offer(point);

        while (!queue.isEmpty()) {
            point = queue.poll();
            if (point.col - 1 >= 0 && matrix[point.row][point.col - 1] == 0) { // left
                queue.offer(new Point(point.row, point.col - 1));
                matrix[point.row][point.col - 1] += 1 + matrix[point.row][point.col];
            }

            if (point.row - 1 >= 0 && matrix[point.row - 1][point.col] == 0) { // up
                queue.offer(new Point(point.row - 1, point.col));
                matrix[point.row - 1][point.col] += 1 + matrix[point.row][point.col];
            }

            if (point.col + 1 < size && matrix[point.row][point.col + 1] == 0) { // right
                queue.offer(new Point(point.row, point.col + 1));
                matrix[point.row][point.col + 1] += 1 + matrix[point.row][point.col];
            }

            if (point.row + 1 < size && matrix[point.row + 1][point.col] == 0) { // down
                queue.offer(new Point(point.row + 1, point.col));
                matrix[point.row + 1][point.col] += 1 + matrix[point.row][point.col];
            }
        }
        matrix[row][col] = -1;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == -1) {
                    System.out.printf("%c", '*');
                } else if (anInt == -2) {
                    System.out.printf("%c", 'x');
                } else if (anInt == 0) {
                    System.out.printf("%c", 'u');
                } else {
                    System.out.printf("%d", anInt);
                }
            }
            System.out.println();
        }
    }
}

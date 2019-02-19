package com.telerikacademy.tasks.Recursion;

public class MazeSolving {

    public static void main(String[] args) {
        char[][] maze = {
                {' ',' ',' ','X', ' ','E'},
                {' ','X','X','X', ' ','X'},
                {' ',' ',' ','X', ' ',' '},
                {' ',' ',' ','X', ' ',' '},
                {' ',' ',' ',' ', ' ',' '},
        };

        int startRow = 0;
        int startCol = 0;
//        solveMaze(maze, startRow, startCol);
        System.out.println(hasSolutionMaze(maze, startRow, startCol));
    }

    private static int counter = 0;
    private static void solveMaze(char[][] maze, int row, int col) {

//        printMatrix(maze);
        if (!isInRange(maze, row, col)) {
            return;
        }

        if (maze[row][col] == 'X') {
            return;
        }
        if (maze[row][col] == 's') {
            return;
        }
        if (maze[row][col] == 'E') {
            counter++;
            printMatrix(maze);
            System.out.println(String.format("%d Path to Exit found! On row: %d and column: %d", counter, row, col));
            return;
        }

//        mark the cell as visited
        maze[row][col] = 's';

        solveMaze(maze, row, col + 1);
        solveMaze(maze, row, col - 1);
        solveMaze(maze, row - 1, col);
        solveMaze(maze, row + 1, col);


        //mark the cell as unvisited when returning.
        maze[row][col] = ' ';

    }

    private static boolean isInRange(char[][] maze, int row, int col) {
        return row < maze.length
                && row >= 0
                && col < maze[0].length
                && col >= 0;
    }

    private static void printMatrix(char[][] maze) {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print("|" + cell);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    private static boolean hasSolutionMaze(char[][] maze, int row, int col) {

        printMatrix(maze);
        if (!isInRange(maze, row, col)) {
            return false;
        }

        if (maze[row][col] == 'X') {
            return false;
        }
        if (maze[row][col] == 's') {
            return false;
        }
        if (maze[row][col] == 'E') {
            System.out.println(String.format("Exit found! On row: %d and column: %d", row, col));
            return true;
        }

        //mark the cell as visited
        maze[row][col] = 's';

        if (hasSolutionMaze(maze, row, col + 1)) {
            return true;
        }
        if (hasSolutionMaze(maze, row - 1, col)) {
            return true;
        }
        if (hasSolutionMaze(maze, row + 1, col)) {
            return true;
        }
        if (hasSolutionMaze(maze, row, col - 1)) {
            return true;
        }

        //mark the cell as unvisited when returning.
        maze[row][col] = ' ';
        System.out.println("------------Dead end---------------");
        return false;
    }
}

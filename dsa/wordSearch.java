

class WordSearch {
    static boolean[][] visited;

    static boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0))
                    return true;

        return false;
    }

    static boolean search(char[][] board, String word, int row, int col, int index) {
        if (index == word.length())
            return true;

        if (row >= board.length || row < 0 || col >= board[row].length || col < 0 ||
                board[row][col] != word.charAt(index) || visited[row][col])
            return false;

        visited[row][col] = true;

        if (search(board, word, row - 1, col, index + 1) ||
                search(board, word, row + 1, col, index + 1) ||
                search(board, word, row, col - 1, index + 1) ||
                search(board, word, row, col + 1, index + 1))
            return true;

        visited[row][col] = false;

        return false;
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        System.out.println(exist(board, "BASAD"));
    }
}
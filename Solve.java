public class Solve {
    Board board;

    public Solve()
    {
        this.board = new Board();
    }

    private boolean check(int row, int col, int grid, int num)
    {
        for (int i = 0; i < board.size; i++)
            if (board.board[row][i] == num)
                return false;
        for (int i = 0; i < board.size; i++)
            if (board.board[i][col] == num)
                return false;
        row = (grid / board.gridSize) * board.gridSize;
        col = (grid % board.gridSize) * board.gridSize;
        for (int i = 0; i < board.gridSize; i++)
            for (int j = 0; j < board.gridSize; j++)
                if (board.board[row + i][col + j] == num)
                    return false;
        return true;
    }

    public boolean solveSudoku(int row, int col)
    {
        int size = board.size;
        row += (col + 1) / size;
        col = (col + 1) % size;
        if (row == size)
            return true;
        if (board.board[row][col] != 0)
            return solveSudoku(row, col);
        int grid = ((row / board.gridSize) * board.gridSize) + (col / board.gridSize);
        for (int i = 1; i < 10; i++)
        {
            if (check(row, col, grid, i))
            {
                board.board[row][col] = i;
                if (solveSudoku(row, col)) {
                    return true;
                }
                board.board[row][col] = 0;
            }
        }
        return false;
    }
}

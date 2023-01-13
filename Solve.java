public class Solve {
    Board board;

    public Solve()
    {
        this.board = new Board();
    }

    private boolean checkDuplicatesInRowCol(int row, int col, int num)
    {
        for (int i = 0; i < board.size; i++)
        {
            if (board.board[row][i] == num || board.board[i][col] == num)
                return false;
        }
        return true;
    }

    private boolean checkDuplicatesInGrid(int grid, int num)
    {
        int row = (grid / board.gridSize) * board.gridSize;
        int col = (grid % board.gridSize) * board.gridSize;
        for (int i = 0; i < board.gridSize; i++)
        {
            for (int j = 0; j < board.gridSize; j++)
            {
                if (board.board[row + i][col + j] == num)
                    return false;
            }
        }
        return true;
    }
    private boolean checkDuplicates(int row, int col, int grid, int num)
    {
        return checkDuplicatesInRowCol(row, col, num) && checkDuplicatesInGrid(grid, num);
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
            if (checkDuplicates(row, col, grid, i))
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

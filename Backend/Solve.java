import static java.lang.Math.sqrt;

public class Solve {
    private Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Solve(Board board)
    {
        this.board = board;
    }

    private boolean checkDuplicatesInRowCol(int row, int col, int num)
    {
        int[][] grid = board.getGrid();
        for (int i = 0; i < board.getSize(); i++)
        {
            if (grid[row][i] == num || grid[i][col] == num)
                return false;
        }
        return true;
    }

    private boolean checkDuplicatesInGrid(int subGrid, int num)
    {
        int[][] grid = board.getGrid();
        int gridSize = (int) sqrt(board.getSize());
        int row = (subGrid / gridSize) * gridSize;
        int col = (subGrid % gridSize) * gridSize;
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                if (grid[row + i][col + j] == num)
                    return false;
            }
        }
        return true;
    }
    private boolean checkDuplicates(int row, int col, int subGrid, int num)
    {
        return checkDuplicatesInRowCol(row, col, num) && checkDuplicatesInGrid(subGrid, num);
    }

    public boolean solveSudoku(int row, int col)
    {
        int size = board.getSize();
        int gridSize = (int) sqrt(board.getSize());
        row += (col + 1) / size;
        col = (col + 1) % size;
        if (row == size)
            return true;
        int[][] grid = board.getGrid();
        if (grid[row][col] != 0)
            return solveSudoku(row, col);
        int subGrid = ((row / gridSize) * gridSize) + (col / gridSize);
        for (int i = 1; i < 10; i++)
        {
            if (checkDuplicates(row, col, subGrid, i))
            {
                grid[row][col] = i;
                board.setGrid(grid);
                if (solveSudoku(row, col)) {
                    return true;
                }
                grid[row][col] = 0;
                board.setGrid(grid);
            }
        }
        return false;
    }
}

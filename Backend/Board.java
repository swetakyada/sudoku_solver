import static java.lang.Math.sqrt;

public class Board {
    private int size;
    int[][] grid;
//            = {
//                    { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
//                    { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
//                    { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
//                    { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
//                    { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
//                    { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
//                    { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
//                    { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
//                    { 0, 0, 0, 0, 8, 0, 0, 7, 9 } }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public Board(int size, int[][] grid)
    {
        this.size = size;
        this.grid = grid;
    }

    void print()
    {
        int subGrid = (int) sqrt(size);
        for (int i = 0; i < size; i++)
        {
            if (i != 0 && i % subGrid == 0)
                System.out.println("------+-------+------");
            for (int j = 0; j < size; j++)
            {
                if (j != 0 && j % subGrid == 0)
                    System.out.print("| ");
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Solve {
    public int[][] board;

    public Solve(int[][] board) {
        this.board = board;
    }

    boolean helper(int r, int c, int g, int n) {
        for (int i = 0; i < 9; i++)
            if (board[r][i] == n)
                return false;
        for (int i = 0; i < 9; i++)
            if (board[i][c] == n)
                return false;
        r = (g / 3) * 3;
        c = (g % 3) * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[r + i][c + j] == n)
                    return false;
        return true;
    }

    boolean solveSudoku(int r, int c) {
        r += (c + 1) / 9;
        c = (c + 1) % 9;
        if (r == 9)
            return true;
        if (board[r][c] != 0)
            return solveSudoku(r, c);
        int g = ((r / 3) * 3) + (c / 3);
        for (int i = 1; i < 10; i++) {
            if (helper(r, c, g, i)) {
                board[r][c] = i;
                // print();
                if (solveSudoku(r, c))
                    return true;
                board[r][c] = 0;
            }
        }
        return false;
    }

    void print() {
        for (int i = 0; i < 9; i++) {
            if (i != 0 && i % 3 == 0)
                System.out.println("------+-------+------");
            for (int j = 0; j < 9; j++) {
                if (j != 0 && j % 3 == 0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class Solution {
    public static void main(String[] args) {
        int[][] board = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
        Solve s = new Solve(board);
        System.out.println("Input : ");
        s.print();
        s.solveSudoku(0, 0);
        System.out.println("Solution : ");
        s.print();
    }
}
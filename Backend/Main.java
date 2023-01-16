import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of board : ");
        int size = sc.nextInt();
        int[][] grid = new int[size][size];
        System.out.println("Enter the values of board : ");
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }
        Board board = new Board(size, grid);
        Solve sol = new Solve(board);
        System.out.println("Input : ");
        sol.getBoard().print();
        System.out.println("Solution : ");
        if(sol.solveSudoku(0, 0))
            sol.getBoard().print();
        else
            System.out.println("No solution possible");
    }
}
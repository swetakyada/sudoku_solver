import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Solve sol = new Solve();
        System.out.println("Input : ");
        sol.board.print();
        System.out.println("Solution : ");
        if(sol.solveSudoku(0, 0))
            sol.board.print();
        else
            System.out.println("No solution possible");
    }
}
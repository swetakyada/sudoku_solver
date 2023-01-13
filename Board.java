import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Board {
    int[][] board;
//            = {
//                    { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
//                    { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
//                    { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
//                    { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
//                    { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
//                    { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
//                    { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
//                    { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
//                    { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
    int size, gridSize;

    public Board()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enetr the size of board : ");
        this.size = sc.nextInt();
        gridSize = (int) sqrt(size);
        board = new int[size][size];
        System.out.println("Enter the values of board : ");
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                board[i][j] = sc.nextInt();
            }
        }
    }

    void print()
    {
        for (int i = 0; i < size; i++)
        {
            if (i != 0 && i % gridSize == 0)
                System.out.println("------+-------+------");
            for (int j = 0; j < size; j++)
            {
                if (j != 0 && j % gridSize == 0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

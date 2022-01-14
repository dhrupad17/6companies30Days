import java.io.*;
import java.util.*;

class sudoku{

static int N = 9;
static boolean isinRange(int[][] board)
{
    for(int i = 0; i < N; i++) 
    {
        for(int j = 0; j < N; j++)
        {
            if (board[i][j] <= 0 ||
                board[i][j] > 9)
            {
                return false;
            }
        }
    }
    return true;
}
static boolean isValidSudoku(int board[][])
{
    if (isinRange(board) == false)
    {
        return false;
    }
    boolean[] unique = new boolean[N + 1];
    for(int i = 0; i < N; i++)
    {
        Arrays.fill(unique, false);
        for(int j = 0; j < N; j++)
        {
            int Z = board[i][j];
            if (unique[Z])
            {
                return false;
            }
            unique[Z] = true;
        }
    }
    for(int i = 0; i < N; i++) 
    {
        Arrays.fill(unique, false);
        for(int j = 0; j < N; j++)
        {
            int Z = board[j][i];
            if (unique[Z]) 
            {
                return false;
            }
            unique[Z] = true;
        }
    }
    for(int i = 0; i < N - 2; i += 3) 
    {
        for(int j = 0; j < N - 2; j += 3)
        {
            Arrays.fill(unique, false);
            for(int k = 0; k < 3; k++)
            {
                for(int l = 0; l < 3; l++)
                {
                    int X = i + k;
                    int Y = j + l;
                    int Z = board[X][Y];
                    if (unique[Z])
                    {
                        return false;
                    }
                    unique[Z] = true;
                }
            }
        }
    }
    return true;
}

// Driver Code
public static void main(String[] args)
{
    int[][] board = { { 7, 9, 2, 1, 5, 4, 3, 8, 6 },
                      { 6, 4, 3, 8, 2, 7, 1, 5, 9 },
                      { 8, 5, 1, 3, 9, 6, 7, 2, 4 },
                      { 2, 6, 5, 9, 7, 3, 8, 4, 1 },
                      { 4, 8, 9, 5, 6, 1, 2, 7, 3 },
                      { 3, 1, 7, 4, 8, 2, 9, 6, 5 },
                      { 1, 3, 6, 7, 4, 8, 5, 9, 2 },
                      { 9, 7, 4, 2, 1, 5, 6, 3, 8 },
                      { 5, 2, 8, 6, 3, 9, 4, 1, 7 } };

    if (isValidSudoku(board)) 
    {
        System.out.println("Valid");
    }
    else
    {
        System.out.println("Not Valid");
    }
}
}
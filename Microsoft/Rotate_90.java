import java.io.*;
class Rotate_90{
    static void rotateMatrix(int N, int mat[][])
    {
        for (int a=0;a<N/2;a++) {
            for (int b=a;b<N-a-1;b++) {
                int temp=mat[a][b];
                mat[a][b]=mat[b][N-1-a];
                mat[b][N-1-a]=mat[N-1-a][N-1-b];
                mat[N-1-a][N-1-b]=mat[N-1-b][a];
                mat[N-1-b][a]=temp;
            }
        }
    }
    static void displayMatrix(
        int N, int mat[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static void main(String[] args)
    {
        int N = 3;
        int mat[][] = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
        rotateMatrix(N, mat);
        displayMatrix(N, mat);
    }
}
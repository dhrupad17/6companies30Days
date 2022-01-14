// Java program to print optimal parenthesization
// in matrix chain multiplication.
class BRACKETS
{
  static char nm;

  // Function for printing the optimal
  // parenthesization of a matrix chain product
  static void printParenthesis(int i, int j, 
                               int n, int[][] bracket)
  {

    // If only one matrix left in current segment
    if (i == j)
    {
      System.out.print(nm++);
      return;
    }
    System.out.print("(");

    // Recursively put brackets around subexpression
    // from i to bracket[i][j].
    // Note that "*((bracket+i*n)+j)" is similar to
    // bracket[i][j]
    printParenthesis(i, bracket[i][j], n, bracket);

    // Recursively put brackets around subexpression
    // from bracket[i][j] + 1 to j.
    printParenthesis(bracket[i][j] + 1, j, n, bracket);
    System.out.print(")");
  }

  // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
  // Please refer below article for details of this
  // function
  // https://goo.gl/k6EYKj
  static void matrixChainOrder(int p[], int n)
  {
    /*
         * For simplicity of the program, 
         one extra row and one extra column are
         * allocated in m[][]. 0th row and 
         0th column of m[][] are not used
         */
    int[][] m = new int[n][n];

    // bracket[i][j] stores optimal break point in
    // subexpression from i to j.
    int[][] bracket = new int[n][n];

    /*
         * m[i,j] = Minimum number of scalar 
         multiplications needed to compute the
         * matrix A[i]A[i+1]...A[j] = A[i..j] where
         dimension of A[i] is p[i-1] x p[i]
         */

    // cost is zero when multiplying one matrix.
    for (int i = 1; i < n; i++)
      m[i][i] = 0;

    // L is chain length.
    for (int length = 2; length < n; length++) 
    {
      for (int i = 1; i < n - length + 1; i++) 
      {
        int j = i + length - 1;
        m[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++)
        {

          // q = cost/scalar multiplications
          int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
          if (q < m[i][j]) 
          {
            m[i][j] = q;

            // Each entry bracket[i,j]=k shows
            // where to split the product arr
            // i,i+1....j for the minimum cost.
            bracket[i][j] = k;
          }
        }
      }
    }

    // The first matrix is printed as 'A', next as 'B',
    // and so on
    nm = 'A';
    System.out.print("Optimal Parenthesization is : ");
    printParenthesis(1, n - 1, n, bracket);
    //System.out.print("\nOptimal Cost is : " + m[1][n - 1]);
  }

  // Driver code
  public static void main(String[] args)
  {
    int arr[] = { 1,2,3,4,5 };
    int n = arr.length;
    matrixChainOrder(arr, n);
  }
}

class VowelWords{
static int power(int x, int y, int p)
{
	int res = 1;
	x = x % p;
	if (x == 0)
		return 0;
	while (y > 0)
	{
		if ((y & 1) != 0)
		res = (res * x) % p;
		y = y >> 1;
		x = (x * x) % p;
	}
	return res;
}
static int kvowelwords(int N, int K)
{
	int i, j;
	int MOD = 1000000007;
	int[][] dp = new int[N + 1][K + 1] ;
	int sum = 1;
	for(i = 1; i <= N; i++)
	{
		dp[i][0] = sum * 21;
		dp[i][0] %= MOD;
		sum = dp[i][0];
		for(j = 1; j <= K; j++)
		{
			if (j > i)
				dp[i][j] = 0;
				
			else if (j == i)
			{
				dp[i][j] = power(5, i, MOD);
			}
			else
			{
				dp[i][j] = dp[i - 1][j - 1] * 5;
			}

			dp[i][j] %= MOD;
			sum += dp[i][j];
			sum %= MOD;
		}
	}
	return sum;
}

public static void main(String[] args)
{
	int N = 1;
	int K = 0;
	System.out.println( kvowelwords(N, K));
}
}

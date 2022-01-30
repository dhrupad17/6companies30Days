import java.util.*;
class Subset{
	static void subsetSums(int arr[], int n)
	{
		int total = 1 << n;
		for (int i = 0; i < total; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++)
				if ((i & (1 << j)) != 0)
					sum += arr[j];
			System.out.print(sum + " ");
		}
	}
	public static void main(String args[])
	{
		int arr[] = new int[] { 5, 4, 3 };
		int n = arr.length;
		subsetSums(arr, n);
	}
}
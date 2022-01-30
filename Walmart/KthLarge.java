import java.util.Arrays;
import java.util.Collections;
class KthLarge{
	public static int kthLargest(Integer[] arr,int k,int n)
	{
		Arrays.sort(arr);
		return arr[n - k];
	}
	public static void main(String[] args)
	{
		Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
		int k =3;
		int n=arr.length;
		System.out.print(kthLargest(arr, k, n));
	}
}
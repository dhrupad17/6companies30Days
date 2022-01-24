import java.io.*;
import java.util.*;
class MountainArray{
    public static int findPeak(ArrayList<Integer> arr)
    {
	int left = 0;
	int right = arr.size() - 1;
	while (left < right) {
		int mid = left + (right - left) / 2;
		if (arr.get(mid) < arr.get(mid + 1)) {
			left = mid + 1;
		}
		else {
			right = mid;
		}
	}
	return left;
}
    static int BS(int X, int left, int right,ArrayList<Integer> arr)
	{
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr.get(mid) == X) {
				return mid;
			}
			else if (X > arr.get(mid)) {
				left = mid + 1;
			}

			else {
				right = mid - 1;
			}
		}
		return -1;
	}
	static int reverseBS(int X, int left, int right,ArrayList<Integer> arr)
	{
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr.get(mid) == X) {
				return mid;
			}

			else if (X > arr.get(mid)) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return -1;
	}
	static void findMinIndex(int X,ArrayList<Integer> mountainArr)
	{
		int peakIndex = findPeak(mountainArr);
		int res = -1;
		if (X >= mountainArr.get(0)
			&& X <= mountainArr.get(peakIndex)) {
			res = BS(X, 0, peakIndex, mountainArr);
		}
		if (res == -1) {
			res = reverseBS(X, peakIndex + 1,mountainArr.size() - 1,mountainArr);
		}
		System.out.println(res);
	}
	public static void main(String[] args)
	{
		int X = 3;
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3, 1));
		findMinIndex(X, list);
	}
}

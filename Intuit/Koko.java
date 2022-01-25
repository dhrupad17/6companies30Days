import java.util.*;
class Koko{
static boolean check(int[] bananas, int mid_val, int H)
{
	int time = 0;
	for (int i = 0; i < bananas.length; i++) {
		if (bananas[i] % mid_val != 0) {
			time += ((bananas[i] / mid_val) + 1);
		}
		else {
			time += (bananas[i] / mid_val);
		}
	}
	if (time <= H) {
		return true;
	}
	else {
		return false;
	}
}
static int minEatingSpeed(int []piles, int H)
{
	int start = 1;
	int end = Arrays.stream(piles).max().getAsInt();

	while (start < end) {
		int mid = start + (end - start) / 2;
		if ((check(piles, mid, H)) == true) {
			end = mid;
		}
		else {
			start = mid + 1;
		}
	}
	return end;
}
public static void main(String[] args)
{
	int []piles = { 3, 6, 7, 11 };
	int H = 8;
	System.out.print(minEatingSpeed(piles, H));
}
}

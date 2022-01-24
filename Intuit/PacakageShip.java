import java.io.*;
class PacakageShip{
static boolean isValid(int[] weight, int n, int D, int mx)
{
    int st = 1;
    int sum = 0;
    for(int i = 0; i < n; i++)
    {
        sum += weight[i];
        if (sum > mx)
        {
            st++;
            sum = weight[i];
        }
        if (st > D)
            return false;
    }
    return true;
}
static void shipWithinDays(int[] weight, int D, int n)
{
    int sum = 0;
    for(int i = 0; i < n; i++)
        sum += weight[i];
    int s = weight[0];
    for(int i = 1; i < n; i++)
    {
        s = Math.max(s, weight[i]);
    }
    int e = sum;
    int result = -1;
    while (s <= e) 
    {
        int mid = s + (e - s) / 2;
        if (isValid(weight, n, D, mid)) 
        {
            result = mid;
            e = mid - 1;
        }
        else
            s = mid + 1;
    }
    System.out.println(result);
}
public static void main(String[] args) 
{
    
    int[] weight = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int Days = 5;
    int N = weight.length;
    
    shipWithinDays(weight, Days, N);
}
}
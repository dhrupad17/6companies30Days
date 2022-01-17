import java.util.*;

class Minsum{
    public static int findMinRec(int arr[],int i,int sumCal,int Total)
    {
        if (i == 0)
            return Math.abs((Total - sumCal)- sumCal);
        return Math.min(findMinRec(arr, i - 1,sumCal + arr[i - 1],Total),
            findMinRec(arr, i - 1, sumCal,Total));
    }
    public static int findMin(int arr[], int n)
    {
        int Total = 0;
        for (int i = 0; i < n; i++)
            Total += arr[i];
        return findMinRec(arr, n, 0, Total);
    }
    public static void main(String[] args)
    {
        int arr[]={1,6,11,5};
        int n=arr.length;
        System.out.print("The minimum difference"+" between two sets is "+ findMin(arr, n));
    }
}
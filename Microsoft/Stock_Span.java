import java.util.Arrays;

class Stock_Span{
    static void calculateSpan(int price[], int n, int Span[])
    {
        Span[0] = 1;
        for (int i = 1; i < n; i++) {
            Span[i] = 1;
            for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--)
                Span[i]++;
        }
    }
    static void printArray(int arr[])
    {
        System.out.print(Arrays.toString(arr));
    }

    public static void main(String[] args)
    {
        int price[] = {100,80,60,70,60,75,85};
        int n = price.length;
        int Span[] = new int[n];
        calculateSpan(price, n, Span);
        printArray(Span);
    }
}
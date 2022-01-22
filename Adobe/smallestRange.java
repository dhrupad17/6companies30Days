class smallestRange{
    static final int N = 5;
    static int ptr[] = new int[500];
    static void findSmallestRange(int arr[][], int n, int k)
    {
        int i, minval, maxval, minrange, minel = 0, maxel = 0, flag, minind;
        for (i = 0; i <= k; i++) {
            ptr[i] = 0;
        }
        minrange = Integer.MAX_VALUE;
        while (true) {
            minind = -1;
            minval = Integer.MAX_VALUE;
            maxval = Integer.MIN_VALUE;
            flag = 0;
            for (i = 0; i < k; i++) {
                if (ptr[i] == n) {
                    flag = 1;
                    break;
                }
                if (ptr[i] < n && arr[i][ptr[i]] < minval) {
                    minind = i;
                    minval = arr[i][ptr[i]];
                }
                if (ptr[i] < n && arr[i][ptr[i]] > maxval) {
                    maxval = arr[i][ptr[i]];
                }
            }
            if (flag == 1) {
                break;
            }
            ptr[minind]++;
            if ((maxval - minval) < minrange) {
                minel = minval;
                maxel = maxval;
                minrange = maxel - minel;
            }
        }
        System.out.printf("The smallest range is [%d, %d]\n", minel, maxel);
    }
    public static void main(String[] args)
    {
  
        int arr[][] = {
            { 4, 7, 9, 12, 15 },
            { 0, 8, 10, 14, 20 },
            { 6, 12, 16, 30, 50 }};
        int k = arr.length;
        findSmallestRange(arr, N, k);
    }
}
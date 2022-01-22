class SubarraySum {
    int subArraySum(int arr[], int n, int sum)
    {
        int temp_sum, i, j;
        for (i = 0; i < n; i++) {
            temp_sum = arr[i];
             for (j = i + 1; j <= n; j++) {
                if (temp_sum == sum) {
                    int p = j - 1;
                    System.out.println((i+1)+ ","+(p+1));
                    return 1;
                }
                if (temp_sum > sum || j == n)
                    break;
                temp_sum = temp_sum + arr[j];
            }
        }
        System.out.println("No subarray found");
        return 0;
    }
    public static void main(String[] args)
    {
        SubarraySum arraysum = new SubarraySum();
        int arr[] = {1,2,3,7,5};
        int n = arr.length;
        int sum =12;
        arraysum.subArraySum(arr, n, sum);
    }
}
public class NutsAndBoltsMatch
{
    //Driver method
    public static void main(String[] args)
    {
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
        matchPairs(nuts, bolts, 0, 5);

        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        printArray(bolts);
    }
    private static void printArray(char[] a) {
        for (char ch : a){
            System.out.print(ch + " ");
        }
        System.out.print("\n");
    }
    private static void matchPairs(char[] nuts, char[] bolts, int l,
                                                              int h)
    {
        if (l < h)
        {
            int pivot = partition(nuts, l, h, bolts[h]);
            partition(bolts, l, h, nuts[pivot]);
            matchPairs(nuts, bolts, l, pivot-1);
            matchPairs(nuts, bolts, pivot+1, h);
        }
    }
    private static int partition(char[] arr, int l, int h, char pivot)
    {
        int i = l;
        char temp1, temp2;
        for (int j = l; j < h; j++)
        {
            if (arr[j] < pivot){
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
            } else if(arr[j] == pivot){
                temp1 = arr[j];
                arr[j] = arr[h];
                arr[h] = temp1;
                j--;
            }
        }
        temp2 = arr[i];
        arr[i] = arr[h];
        arr[h] = temp2;
        return i;
    }
}
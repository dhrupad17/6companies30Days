class Convert_Array {
    static void checkArray(int a[], int b[], int n)
    {
        int steps = 0;
        int i = 0;
        while (i < n) {
            if (a[i] - b[i] == 0) {
                i++;
                continue;
            }
            int diff = a[i] - b[i];
            while (i < n &&
               a[i] - b[i] == diff) {
                i++;
            }
            steps++;
        }
        System.out.println(steps);
    }
    public static void main (String[] args)
    {
        int a[] = { 1, 3, 5 };
        int b[] = { 1, 3, 5 };
        int size = a.length;
        checkArray(a, b, size);
    }
}
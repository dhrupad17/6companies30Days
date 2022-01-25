class BinaryGrid {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i ++) {
            int[] row = grid[i];
            for (int j = n - 1; j >= 0; j --) {
                if (row[j] == 0) {
                    count[i] ++;
                } else {
                    break;
                }
            }
        }       
        int swap = 0;
        for (int i = 0; i < n; i ++) {
            boolean found = false;
            int minZeros = n - i - 1;
            if (count[i] < minZeros) {
               for (int j = i + 1; j < n; j ++) {
                    if (count[j] >= minZeros)  {
                        found = true;
                        swap += j - i;
                        while (j > i) {
                            swap(count, j, j - 1);
                            j --;
                        }
                        break;
                    }
                }
                if (!found) { 
                    return -1;
                }
            }
        }
        return swap;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
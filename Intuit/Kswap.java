import java.io.*;
class Kswap{
    static String max = "";
}
class Solution {
    public static void findMaximumNum(char ar[], int k, Kswap r)
    {
        if (k == 0)
            return;
        int n = ar.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ar[j] > ar[i]) {
                    char temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                    String st = new String(ar);
                    if (r.max.compareTo(st) < 0) {
                        r.max = st;
                    }
                    findMaximumNum(ar, k - 1, r);
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        String str = "1234567";
        int k = 4;
        Kswap r = new Kswap();
        r.max = str;
        findMaximumNum(str.toCharArray(), k, r);
        System.out.println(r.max);
    }
}
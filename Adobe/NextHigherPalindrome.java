import java.util.*;
class NextHigherPalindrome
{
    public static void reverse(char num[], int i,int j)
    {
        while (i < j) {
            char temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
    }
    public static void nextPalindrome(char num[], int n)
    {
        if (n <= 3) {
            System.out.println("Not Possible");
            return;
        }
        char temp;
        int mid = n / 2 - 1;
        int i, j;
        for (i = mid - 1; i >= 0; i--)
            if (num[i] < num[i + 1])
                break;
        if (i < 0) {
            System.out.println("Not Possible");
            return;
        }
        int smallest = i + 1;
        for (j = i + 2; j <= mid; j++)
            if (num[j] > num[i] &&
                num[j] <= num[smallest])
                smallest = j;
        temp = num[i];
        num[i] = num[smallest];
        num[smallest] = temp;
        temp = num[n - i - 1];
        num[n - i - 1] = num[n - smallest - 1];
        num[n - smallest - 1] = temp;
        reverse(num, i + 1, mid);
        if (n % 2 == 0)
            reverse(num, mid + 1, n - i - 2);
        else
            reverse(num, mid + 2, n - i - 2);
        String result=String.valueOf(num);
        System.out.println("Next Palindrome: "+result);
    }
    public static void main(String args[])
    {
        String str="35453";
        char num[]=str.toCharArray();
        int n=str.length();
        nextPalindrome(num,n);
    }
}
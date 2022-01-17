import java.io.*;
class SticklerThief
{
    static int maxLoot(int house_value[], int n)
    {
        if (n == 0)
        return 0;
        if (n == 1)
            return house_value[0];
        if (n == 2)
            return Math.max(house_value[0], house_value[1]);
        int[] temp = new int[n];
        temp[0] = house_value[0];
        temp[1] = Math.max(house_value[0], house_value[1]);
        for (int i = 2; i<n; i++)
            temp[i] = Math.max(house_value[i]+temp[i-2], temp[i-1]);
        return temp[n-1];
    }
    public static void main (String[] args)
    {
        int house_value[] = {6, 7, 1, 3, 8, 2, 4};
        int n = house_value.length;
        System.out.println("Maximum loot value : " + maxLoot(house_value, n));
    }
}
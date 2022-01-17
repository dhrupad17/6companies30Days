import java.io.*;
class Minimum_Steps
{
    static int steps(int source, int step,int dest)
    {
        if (Math.abs(source) > (dest)) 
            return Integer.MAX_VALUE;
        if (source == dest) 
            return step;
        int pos = steps(source + step + 1,step + 1, dest);
        int neg = steps(source - step - 1,step + 1, dest);
        return Math.min(pos, neg);
    }
    public static void main(String[] args)
    {
        int dest = 11;
        System.out.println("No. of steps required"+" to reach " + dest +" is " + steps(0, 0, dest));
    }
}

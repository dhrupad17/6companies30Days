class nth_stairs {
    static int countWays(int s)
    {
        return (int)(s/2)+1;
    }
    public static void main(String args[])
    {
        int order= 4;
        System.out.println("Number of ways = " + countWays(order));
    }
} 
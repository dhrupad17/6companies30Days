import java.io.*;

import java.math.BigDecimal;
import java.util.*;
public class Stone_Game{
    void solve()throws Exception
    {
        int testCases=1;
        for(int test=1;test<=testCases;test++)
        {
            solveTestCase(test);
        }
    }
    final static long mod=1000000007;
    private void solveTestCase(int testNumber)throws Exception{
        int n=nextInt();
        int[]a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=nextInt();
        long res=doIt(a);
        for(int i=0;i<n;i++)
            a[i]--;
        res-=doIt(a);
        res+=mod;
        res%=mod;
        System.out.println(res);
    }
    private long doIt(int[] a) {
        int highestBit=-1;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>0)
                highestBit=Math.max(highestBit, Integer.highestOneBit(a[i]));
        }
        if(highestBit==-1)
            return 1;
        int cnt=0;
        ArrayList<Integer>list=new ArrayList<Integer>();
        long other=1;
        for(int i=0;i<a.length;i++)
        {
            if(highestBit==Integer.highestOneBit(a[i]))
                list.add(a[i]^highestBit);
            else
                other=other*(a[i]+1)%mod;
        }
        long[]dp=getDp(list,highestBit);
        long res=0;
        for(int k=1;k<dp.length;k++)
        if((list.size()-k)%2==0)
        {
            res=res+dp[k]*other;
            res%=mod;
        }
        if(list.size()%2==0)
        {
            int[]b=a.clone();
            for(int i=0;i<a.length;i++)
            {
                if(highestBit==Integer.highestOneBit(b[i]))
                    b[i]^=(highestBit);
            }
            res+=doIt(b);
            res%=mod;
        }
        return res;
    }
    private long[] getDp(ArrayList<Integer> list,int mul) {
        int[]a=new int[list.size()];
        for(int i=0;i<a.length;i++)
            a[i]=list.get(i);
        long[]dp=new long[a.length+1];
        dp[0]=1;
        for(int x: a)
        {
            long[]next=new long[dp.length];
            for(int i=0;i<dp.length;i++)
            {
                next[i]=dp[i];       
                if(i>0)
                {
                    next[i]+=dp[i-1]*(x+1);
                    next[i]%=mod;
                }
            }
            dp=next;
        }
        long[]res=new long[dp.length];
        long v=1;
        for(int k=1;k<res.length;k++)
        {
            res[k]=dp[a.length-k]*v;
            res[k]%=mod;
            v=v*mul%mod;
        }
        return res;
    }
    BufferedReader reader;
    PrintWriter writer;
    StringTokenizer stk;
    void run()throws Exception
    {
        reader=new BufferedReader(new InputStreamReader(System.in));
        stk=null;
        writer=new PrintWriter(new PrintWriter(System.out)); 
        solve();
        reader.close();
        writer.close();
    }
    int nextInt()throws Exception
    {
        return Integer.parseInt(nextToken());
    }
    long nextLong()throws Exception
    {
        return Long.parseLong(nextToken());
    }
    double nextDouble()throws Exception
    {
        return Double.parseDouble(nextToken());
    }
    String nextString()throws Exception
    {
        return nextToken();
    }
    String nextLine()throws Exception
    {
        return reader.readLine();
    }
    String nextToken()throws Exception
    {
        if(stk==null || !stk.hasMoreTokens())
        {
            stk=new StringTokenizer(nextLine());
            return nextToken();
        }
        return stk.nextToken();
    }
    public static void main(String[]args) throws Exception
    {
        new Stone_Game().run();
    }
}
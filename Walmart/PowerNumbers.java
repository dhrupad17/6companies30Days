class PowerNumbers
{
    public long modfun(long n, long  R)
    { 
        if (n == 0) 
            return 0; 
        if (R == 0)  
            return 1; 
        long y; 
        if (R % 2 == 0) { 
            y = modfun(n, R/2);  
            y = (y * y) % 1000000007; 
        }  
        else { 
            y = n % 1000000007; 
            y = (y * modfun(n, R - 1) % 1000000007) % 1000000007; 
        } 
        return ((y + 1000000007) % 1000000007);  
        }
    long power(int N,int R)
    {
        return modfun(N,R)%1000000007;
        
    }

}
#include<stdio.h>

int main()

{

    long long int n;

    scanf("%lld",&n);

    printf("%lld",(n*(n+1)*((2*n)+1))/6);

    return 0;

}
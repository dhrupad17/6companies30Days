def Divide(n1,n2):
    while (n1%n2==0):
        n1=n1/n2
    return n1

def isUgly(num):
    num=Divide(num, 2)
    num=Divide(num, 3)
    num=Divide(num, 5)
    if num==1:
        return 1
    else:
        return 0

def getNthUglyNo(n):
    i=1
    count=1 

    while n>count:
        i+=1
        if isUgly(i):
            count+=1
    return i

num=getNthUglyNo(100)
print("100th ugly no. is ", num)
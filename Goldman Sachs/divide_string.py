def gcd(s1, s2):
    if(len(s1) < len(s2)):
        return gcd(s2, s1)

    elif(not s1.startswith(s2)):
        return -1
    elif(len(s2) == 0):
        return s1
    else:
        return gcd(s1[len(s2):], s2)

def findGCD(arr, n):
    result = arr[0] 
    for i in range(1, n):
        result = gcd(result, arr[i])
    return result

arr=["ABCD","ABCD","ABCDABCD"]
size = len(arr)

print(findGCD(arr, size))
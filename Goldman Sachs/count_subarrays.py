def countsubarrays(arr, n, k):
    count=0
    for i in range(0, n):
        if (arr[i]<k):
            count+= 1
        prod=arr[i]
        for j in range(i+1,n):
            prod=prod*arr[j]
            if prod<k:
                count+=1
            else:
                break
    return count

arr = [1,2,3,4,5,6]
k=12
size=len(arr)
count=countsubarrays(arr,size,k)
print(count,end=" ")
def printTwoElements(arr,n):
    for i in range(n):
        if arr[abs(arr[i])-1] > 0:
            arr[abs(arr[i])-1] = -arr[abs(arr[i])-1]
        else:
            print("Repeating=", abs(arr[i]))
             
    for i in range(n):
        if arr[i]>0:
            print("Missing= ", i + 1)

arr = [1,4,2,2,4,6,7]
n = len(arr)
printTwoElements(arr, n)
def minsubsum(arr, n, x):

    # Initialize length of smallest
    # subarray as n+1
    min_len = n + 1

    # Pick every element as starting point
    for start in range(0,n):
    
        # Initialize sum starting 
        # with current start
        curr_sum = arr[start]

        # If first element itself is greater
        if (curr_sum >= x):
            return 1

        # Try different ending points
        # for curremt start
        for end in range(start+1,n):
        
            # add last element to current sum
            curr_sum += arr[end]

            # If sum becomes more than x 
            # and length of this subarray
            # is smaller than current smallest
            # length, update the smallest 
            # length (or result)
            if curr_sum >= x and (end - start + 1) < min_len:
                min_len = (end - start + 1)
        
    return min_len


# Driver program to test above function */
arr = [2,3,1,2,4,3]
x = 7
n1 = len(arr)
result = minsubsum(arr, n1, x)
if result == n1+1:
    print("0")
else:
    print(result)
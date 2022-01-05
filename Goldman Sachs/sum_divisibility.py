from collections import defaultdict

def canPairs(arr, n, k):

    # An odd length array cannot
    # be divided into pairs
    if (n & 1):
        return 0

    # Create a frequency array to
    # count occurrences of all
    # remainders when divided by k.
    freq=defaultdict(lambda: 0)

    # Count occurrences of all remainders
    for i in range(0, n):
        freq[((arr[i] % k) + k) % k] += 1

    # Traverse input array and use
    # freq[] to decide if given array
    # can be divided in pairs
    for i in range(0, n):

        # Remainder of current element
        rem=((arr[i]%k)+k)%k

        # If remainder with current element
        # divides k into two halves.
        if(2 * rem == k):

            # Then there must be even occurrences
            # of such remainder
            if (freq[rem] % 2 != 0):
                return 0

        # If remainder is 0, then there
        # must be two elements with 0 remainde
        elif (rem == 0):
            if (freq[rem] & 1):
                return 0

            # Else number of occurrences of
            # remainder must be equal to
            # number of occurrences of
            # k - remainder
        elif (freq[rem] != freq[k - rem]):
             return 0

    return 1


# Driver code
# arr=[92,75,65,48,45,35]
# k=10
arr=[2,4,1,3]
k=4
n = len(arr)

# Function call
if (canPairs(arr, n, k)):
    print("True")
else:
    print("False")
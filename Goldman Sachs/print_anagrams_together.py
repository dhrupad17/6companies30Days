# Given an array of strings, return all groups of strings that are anagrams
total_char= 256
def areAnagram(str1: str, str2: str) -> bool:
    count =[0]*total_char
    i = 0
    while(i<len(str1) and i<len(str2)):
        count[ord(str1[i])]+= 1
        count[ord(str2[i])]-= 1
        i += 1
    
    if (len(str1)!=len(str2)):
        return False

    for i in range(total_char):
        if count[i]:
            return False
        return True

def findAllAnagrams(arr: list, n: int):
    for i in range(n):
        for j in range(i + 1, n):
            if areAnagram(arr[i], arr[j]):
                print("(",arr[i],",",arr[j],")")
 
if __name__ == "__main__":
    arr=[]
    n=int(input("Enter number of strings you want to enter "))
    for i in range(0,n):
        ele=input()
        arr.append(ele)
    findAllAnagrams(arr, n)
 
import java.io.*;
class Subtree
{
    int data;
    Subtree left;
    Subtree right;
    Subtree(int data)
    {
        this.data = data;
    }
}

class Count_subTree
{
    static int count = 0;
    static Subtree ptr;
    int countSubtreesWithSumXUtil(Subtree root, int sum)
    {
        int lft = 0, rght = 0;
        if(root == null) 
        return 0;
        lft += countSubtreesWithSumXUtil(root.left, sum);
        rght += countSubtreesWithSumXUtil(root.right, sum);
        if(lft + rght + root.data == sum) 
        count++;
        if(ptr != root) 
        return lft + root.data + rght;
        return count;
    }

    // Driver Code
    public static void main(String[] args)
    {
        /* binary tree creation 
             5 
            / \ 
           -10 3 
           / \ / \ 
          9 8 -4 7 
        */
        Subtree root = new Subtree(5);
        root.left = new Subtree(-10);
        root.right = new Subtree(3);
        root.left.left = new Subtree(9);
        root.left.right = new Subtree(8);
        root.right.left = new Subtree(-4);
        root.right.right = new Subtree(7);
        int sum = 7;
        ptr=root;
        System.out.println("Count = " +new Count_subTree().countSubtreesWithSumXUtil(root, sum));
    }
}
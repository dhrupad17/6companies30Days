import java.util.*;
class connect_Nodes{
    static class node {
  
        int data;
        node left;
        node right;
        node nextRight;
        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.nextRight = null;
        }
    };
    static void connect(node p) {
        p.nextRight = null;
        connectRecur(p);
    }
    static void connectRecur(node p) {
        if (p == null)
            return;
        if (p.left != null)
            p.left.nextRight = p.right;
        if (p.right != null)
            p.right.nextRight = (p.nextRight) != null ? p.nextRight.left : null;
        connectRecur(p.left);
        connectRecur(p.right);
    }
    public static void main(String[] args) {
        node root = new node(10);
        root.left = new node(8);
        root.right = new node(2);
        root.left.left = new node(3);
        connect(root);
        System.out.print("Following are populated nextRight pointers in the tree"+ " (-1 is printed if there is no nextRight)\n");
        System.out.print("nextRight of " + root.data + " is " + (root.nextRight != null ? root.nextRight.data : -1) + "\n");
        System.out.print("nextRight of " + root.left.data + " is "+ (root.left.nextRight != null ? root.left.nextRight.data : -1) + "\n");
        System.out.print("nextRight of " + root.right.data + " is " + (root.right.nextRight != null ? root.right.nextRight.data : -1) + "\n");
        System.out.print("nextRight of " + root.left.left.data + " is "+ (root.left.left.nextRight != null ? root.left.left.nextRight.data : -1) + "\n");
    }
}
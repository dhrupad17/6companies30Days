import java.util.*;
class Tree_Ser_Deser {
    int val;
    Tree_Ser_Deser left;
    Tree_Ser_Deser right;
    Tree_Ser_Deser(int x) { val = x; }
}
class BinaryTree {
    Tree_Ser_Deser root;
    public static String serialize(Tree_Ser_Deser root)
    {
        if (root == null) {
            return null;
        }
        Stack<Tree_Ser_Deser> s = new Stack<>();
        s.push(root);
        List<String> l = new ArrayList<>();
        while (!s.isEmpty()) {
            Tree_Ser_Deser t = s.pop();
            if (t == null) {
                l.add("#");
            }
            else {
                l.add("" + t.val);
                s.push(t.right);
                s.push(t.left);
            }
        }
        return String.join(",", l);
    }
    static int t;
    public static Tree_Ser_Deser deserialize(String data)
    {
        if (data == null)
            return null;
        t = 0;
        String[] arr = data.split(",");
        return helper(arr);
    }
    public static Tree_Ser_Deser helper(String[] arr)
    {
        if (arr[t].equals("#"))
            return null;
        Tree_Ser_Deser root
            = new Tree_Ser_Deser(Integer.parseInt(arr[t]));
        t++;
        root.left = helper(arr);
        t++;
        root.right = helper(arr);
        return root;
    }
    static void inorder(Tree_Ser_Deser root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Tree_Ser_Deser(20);
        tree.root.left = new Tree_Ser_Deser(8);
        tree.root.right = new Tree_Ser_Deser(22);
        tree.root.left.left = new Tree_Ser_Deser(4);
        tree.root.left.right = new Tree_Ser_Deser(12);
        tree.root.left.right.left = new Tree_Ser_Deser(10);
        tree.root.left.right.right = new Tree_Ser_Deser(14);
        String serialized = serialize(tree.root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();
        Tree_Ser_Deser t = deserialize(serialized);
        System.out.println("Inorder Traversal of the tree constructed from serialized String:");
        inorder(t);
    }
}
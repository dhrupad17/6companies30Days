import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 
class Burn_Tree
{
    int val;
    Burn_Tree left;
    Burn_Tree right;
    Burn_Tree() {}
    Burn_Tree(int val) { this.val = val; }
    Burn_Tree(int val, Burn_Tree left, Burn_Tree right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    public static int search(Burn_Tree root,
                              int num,
                              Map<Integer,
                             Set<Integer> > levelOrderMap)
    {
        if (root != null)
        {
            if (root.val == num)
            {
 
                levelOrderStoredInMap(root.left, 1,
                                      levelOrderMap);
                levelOrderStoredInMap(root.right, 1,
                                      levelOrderMap);
                return 1;
            }
            int key = search(root.left, num, levelOrderMap);
            if (key > 0)
            {
                storeRootAtK(root, key, levelOrderMap);
                levelOrderStoredInMap(root.right, key + 1,
                                      levelOrderMap);
                return key + 1;
            }
            key = search(root.right, num, levelOrderMap);
            if (key > 0)
            {
                storeRootAtK(root, key, levelOrderMap);
                levelOrderStoredInMap(root.left, key + 1,
                                      levelOrderMap);
                return key + 1;
            }
        }
        return -1;
    }
 
    public static void levelOrderStoredInMap(
        Burn_Tree root, int key,
        Map<Integer, Set<Integer> > levelOrderMap)
    {
        if (root != null) {
            storeRootAtK(root, key, levelOrderMap);
            levelOrderStoredInMap(root.left, key + 1,
                                  levelOrderMap);
            levelOrderStoredInMap(root.right, key + 1,
                                  levelOrderMap);
        }
    }
 
    private static void
    storeRootAtK(Burn_Tree root, int key,
                 Map<Integer, Set<Integer> > levelOrderMap)
    {
        if (levelOrderMap.containsKey(key)) {
            levelOrderMap.get(key).add(root.val);
        }
        else {
            Set<Integer> set = new HashSet<>();
            set.add(root.val);
            levelOrderMap.put(key, set);
        }
    }
    public static void main(String[] args)
    {
 
        /*  12
           /  \
          13  10
              / \
             14 15
            / \ / \
          21 24 22 23
 
        Let us create Binary Tree as shown
        above */
        Burn_Tree root = new Burn_Tree(12);
        root.left = new Burn_Tree(13);
        root.right = new Burn_Tree(10);
        root.right.left = new Burn_Tree(14);
        root.right.right = new Burn_Tree(15);
        Burn_Tree left = root.right.left;
        Burn_Tree right = root.right.right;
        left.left = new Burn_Tree(21);
        left.right = new Burn_Tree(24);
        right.left = new Burn_Tree(22);
        right.right = new Burn_Tree(23);
        Map<Integer, Set<Integer> > levelOrderMap
            = new HashMap<>();
        search(root, 14, levelOrderMap);
        System.out.println(14);
        for (Integer level : levelOrderMap.keySet())
        {
            for (Integer val : levelOrderMap.get(level))
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
     
     
}
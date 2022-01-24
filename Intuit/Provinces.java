import java.io.*;
import java.util.*;
class Provinces {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }
            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
class Solution {
    
  public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int src)
  {
      vis[src]=true;
      for(int i=0;i<adj.get(src).size();i++)
      {
          if(vis[i]!=true && adj.get(src).get(i)==1)
          {
              dfs(adj,vis,i);
          }
      }
  }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean vis[]=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++)
        {
            if(vis[i]!=true)
            {
                count++;
                
                dfs(adj,vis,i);
            }
        }
        return count;
        
    }
};
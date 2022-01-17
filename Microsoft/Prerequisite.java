import java.util.*;

public class Prerequisite{
    static class pair{
        int first, second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    static ArrayList<ArrayList<Integer>> make_graph(int numTasks,
                Vector<pair> prerequisites)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numTasks);
        for(int i=0; i<numTasks; i++){
            graph.add(new ArrayList<Integer>());
        }
        for (pair pre : prerequisites)
            graph.get(pre.second).add(pre.first);
        return graph;
    }
    static boolean dfs_cycle(ArrayList<ArrayList<Integer>> graph, int node,
                boolean onpath[], boolean visited[])
    {
        if (visited[node])
            return false;
        onpath[node] = visited[node] = true;
        for (int neigh : graph.get(node))
            if (onpath[neigh] || dfs_cycle(graph, neigh, onpath, visited))
                return true;
        return onpath[node] = false;
    }
    static boolean canFinish(int numTasks, Vector<pair> prerequisites)
    {
        ArrayList<ArrayList<Integer>> graph = make_graph(numTasks, prerequisites);   
        boolean onpath[] = new boolean[numTasks];
        boolean visited[] = new boolean[numTasks];
        for (int i = 0; i < numTasks; i++)
            if (!visited[i] && dfs_cycle(graph, i, onpath, visited))
                return false;
        return true;
    }
    public static void main(String args[])
    {
        int numTasks = 3;
        Vector<pair> prerequisites = new Vector<pair>();;
    
        // for prerequisites: [[1, 0], [2, 1]]
    
        prerequisites.add(new pair(1, 0));
        prerequisites.add(new pair(2, 1));
        if (canFinish(numTasks, prerequisites)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
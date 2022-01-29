import java.util.*;
class MaxProb{
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, List<double[]>> nodeToEdges = new HashMap<>();
        for(int i = 0; i < edges.length; i++)
        {
            List<double[]> l0 = nodeToEdges.getOrDefault(edges[i][0], new ArrayList<>());
            List<double[]> l1 = nodeToEdges.getOrDefault(edges[i][1], new ArrayList<>());
            l0.add(new double[]{edges[i][1], succProb[i]});
            l1.add(new double[]{edges[i][0], succProb[i]});
            nodeToEdges.put(edges[i][0], l0);
            nodeToEdges.put(edges[i][1], l1);
        }
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((i1, i2)->{
            double diff = i2[1]-i1[1];
            if(Math.abs(diff)<1e-5)return 0;
            if(diff < 0)return -1;
            return 1;
        });
        pq.offer(new double[]{start, 1.0});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        while(!pq.isEmpty())
        {
            double[] cur = pq.poll();
            int node = (int)(cur[0]);
            visited.add(node);
            if(node==end)return cur[1];
            for(double[] next :nodeToEdges.getOrDefault(node, new ArrayList<>()))
            {
                int nnode = (int)(next[0]);
                if(!visited.contains(nnode))
                {
                    pq.offer(new double[]{nnode, next[1] * cur[1]});
                }
            }
        }
        
        return 0;
    }
}
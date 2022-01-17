import java.util.LinkedList;
public class CheckIfEdgeIsBridge {
    static class Graph {
        int vertices;
        LinkedList<Integer> adjList[];
        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int source, int destination) {
            adjList[source].addFirst(destination);
            adjList[destination].addFirst(source);
        }
        public void removeEdge(int source, int destination) {
            for (int i = 0; i <adjList[source].size() ; i++) {
                if(adjList[source].get(i)==destination) {
                    adjList[source].remove(i);
                    break;
                }
            }
            for (int i = 0; i <adjList[destination].size() ; i++) {
                if(adjList[destination].get(i)==source) {
                    adjList[destination].remove(i);
                    break;
                }
            }
        }
        public int countConnectedComponents() {
            boolean[] visited = new boolean[vertices];
            int count = 0;
            int index;
            while((index = checkGraphIsVisited(visited))!=-1){
                dfs(index, visited);
                count++;
            }
            return count;
        }
        public int checkGraphIsVisited(boolean[] visited){
            for (int i = 0; i <visited.length ; i++) {
                if(!visited[i])
                    return i;
            }
            return -1;
        }
        public void dfs(int start, boolean[] visited) {
            visited[start] = true;
            for (int i = 0; i < adjList[start].size(); i++) {
                int destination = adjList[start].get(i);
                if (!visited[destination])
                    dfs(destination, visited);
            }
        }
    }
    public void edgeIsBridge(int source, int destination, Graph graph){
        int countConnectedSubgraphs = graph.countConnectedComponents();
        graph.removeEdge(source, destination);
        int newCount = graph.countConnectedComponents();
        if(countConnectedSubgraphs==newCount){
            System.out.println("Given Edge ("+source+"-"+destination+") is not a BRIDGE");
        }else{
            System.out.println("Given Edge ("+source+"-"+destination+") is a BRIDGE");
        }
        System.out.println("-----------------------------------------");
        graph.addEdge(source, destination);
    }
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        CheckIfEdgeIsBridge c = new CheckIfEdgeIsBridge();
        c.edgeIsBridge(0,1, graph);
        c.edgeIsBridge(3,4, graph);
        c.edgeIsBridge(2,3, graph);
    }
}
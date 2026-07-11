import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
         ArrayList<Integer> res = new ArrayList<>();
         Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        visited[0] = true;
        queue.offer(0);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for(int neighbour: adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return res;
    } 

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 5; 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        System.out.println(bfsOfGraph(V, adj));
    }
}

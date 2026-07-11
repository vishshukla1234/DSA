import java.util.*;
public class dfs {
    public static ArrayList<Integer> dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res) {
        
        visited[src] = true;
        res.add(src);
        for(int n: adj.get(src)) {
            if(!visited[n]) {
                visited[n] = true;
                dfs(n, adj, visited, res);
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
        ArrayList<Integer> res =  new ArrayList<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        // addEdge(adj, 3, 4);

        System.out.println(dfs(0, adj, visited, res));
    }
}

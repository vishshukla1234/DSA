import java.util.*;
public class Graph {

    class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            node = n;
            weight = w;
        }

        @Override 
        public String toString() {
            return "(" +node +","+weight +")";
        }
    }

    int adjMatrix[][];
    List<List<Integer>> adjList;
    List<List<Pair>> adjListWithWeight;

    Graph(int nodes) {
        adjMatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        adjListWithWeight = new ArrayList<>();
        for(int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }

    public void addEdges(int edges[][], boolean isDirected) {
        for(int edge[]: edges) {
            int u = edge[0];
            int v = edge[1];
            if(isDirected) {
                // directed
                adjMatrix[u][v] = 1;
            } else {
                // un-directed
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    public void addEdgesInList(int edges[][], boolean isDirected) {
        for(int edge[]: edges) {
            int u = edge[0];
            int v = edge[1];
            if(isDirected) {
                // directed
                adjList.get(u).add(v);
            } else {
                // un-directed
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }

    public void addEdgesWithWeights(int edges[][], boolean isDirected) {
        for(int edge[]: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
              
            if(isDirected) {
                // directed
                adjMatrix[u][v] = w;
            } else {
                // un-directed
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }
        }
    }

    public void printList() {
        for(int i = 0; i <adjList.size(); i++) {
            System.out.print(i + " -> ");
            System.out.print("[");
            for(int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void printGraph() {
        for(int i = 0; i < adjMatrix.length; i++) {
            System.out.print("row "+i+" -> ");
            for(int j = 0; j < adjMatrix[0].length; j++) {
                System.out.print(adjMatrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    public void addEdgesWithWeightsInList(int edges[][], boolean isDirected) {
        for(int edge[]: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
              
            if(isDirected) {
                Pair pair = new Pair(v,w);
                // directed
                adjListWithWeight.get(u).add(pair);
            } else {
                Pair pair1 = new Pair(v,w);
                Pair pair2 = new Pair(u,w);
                // un-directed
                adjListWithWeight.get(u).add(pair1);
                adjListWithWeight.get(v).add(pair2);
            }
        }
    }

    public void printWeightedList() {
        for(int i = 0; i <adjListWithWeight.size(); i++) {
            System.out.print(i + " -> ");
            System.out.print("[");
            for(int j = 0; j < adjListWithWeight.get(i).size(); j++) {
                System.out.print(adjListWithWeight.get(i).get(j) + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }
    
    public void findDegreeInUndirectedGraph(int edges[][], int nodes) {
        int degree[] = new int[nodes];
        for(int edge[]: edges) {
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }

        // print
        for(int i = 0; i < nodes; i++) {
            System.out.println("node -> " + i + " degree -> "+degree[i]);
        }
    }
    
    public void findDegreeInDirectedGraph(int edges[][], int nodes) {
        int inDegree[] = new int[nodes];
        int outDegree[] = new int[nodes];
        for(int edge[]: edges) {
            int from = edge[0];
            int to = edge[1];
            inDegree[to]++;
            outDegree[from]++;
        }

        // print
        for(int i = 0; i < nodes; i++) {
            System.out.println("node -> " + i + " in-degree -> "+inDegree[i]);
            System.out.println("node -> " + i + " out-degree -> "+outDegree[i]);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // int edges[][] = {{0,2,10}, {0,1,20}, {1,3,30}};
        // int nodes = 4;
        // Graph graph = new Graph(nodes);
        // graph.addEdges(edges, false);
        // graph.printGraph();
        // System.out.println("=============================");
        // Graph graph1 = new Graph(nodes);
        // graph1.addEdges(edges, true);
        // graph1.printGraph();

        // int edges[][] = {{0,2,10}, {0,1,20}, {1,3,30}};
        // int nodes = 4;
        // Graph graph = new Graph(nodes);
        // System.out.println("Weighted undirected graph");
        // graph.addEdges(edges, false);
        // graph.printGraph();
        // System.out.println("=============================");
        // Graph graph1 = new Graph(nodes);
        // System.out.println("Weighted directed graph");
        // graph1.addEdges(edges, true);
        // graph1.printGraph();

        // int edges[][] = {{0,2}, {0,1}, {1,3}};
        // int nodes = 4;
        // Graph graph = new Graph(nodes);
        // System.out.println("Undirected graph");
        // graph.addEdgesInList(edges, false);
        // graph.printList();
        // System.out.println("=============================");
        // Graph graph1 = new Graph(nodes);
        // System.out.println("Directed graph");
        // graph1.addEdgesInList(edges, true);
        // graph1.printList();
    
        // int edges[][] = {{0,2,10}, {0,1,20}, {1,3,30}};
        // int nodes = 4;
        // Graph graph = new Graph(nodes);
        // System.out.println("Weighted undirected graph");
        // graph.addEdgesWithWeightsInList(edges, false);
        // graph.printWeightedList();
        // System.out.println("=============================");
        // Graph graph1 = new Graph(nodes);
        // System.out.println("Weighted directed graph");
        // graph1.addEdgesWithWeightsInList(edges, true);
        // graph1.printWeightedList();

        int edges[][] = {{0,2}, {0,1}, {1,3}};
        Graph graph = new Graph(4);
        System.out.println("Undirected");
        graph.findDegreeInUndirectedGraph(edges, 4);
        System.out.println("Directed");
        graph.findDegreeInDirectedGraph(edges, 4);
    }
}

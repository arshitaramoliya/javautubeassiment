import java.util.*;

/**
 * Undirected Graph — adjacency list representation
 * Includes BFS and DFS traversal
 */
public class Graph {
    private final Map<Integer, List<Integer>> adj = new HashMap<>();

    public void addVertex(int v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    // BFS — shortest path in unweighted graph
    public List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbour : adj.getOrDefault(node, List.of())) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return result;
    }

    // DFS — recursive
    public List<Integer> dfs(int start) {
        List<Integer> result = new ArrayList<>();
        dfsHelper(start, new HashSet<>(), result);
        return result;
    }

    private void dfsHelper(int node, Set<Integer> visited, List<Integer> result) {
        visited.add(node);
        result.add(node);
        for (int neighbour : adj.getOrDefault(node, List.of())) {
            if (!visited.contains(neighbour)) dfsHelper(neighbour, visited, result);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2); g.addEdge(1, 3);
        g.addEdge(2, 4); g.addEdge(3, 5);

        System.out.println("BFS from 1: " + g.bfs(1)); // [1, 2, 3, 4, 5]
        System.out.println("DFS from 1: " + g.dfs(1)); // [1, 2, 4, 3, 5]
    }
}

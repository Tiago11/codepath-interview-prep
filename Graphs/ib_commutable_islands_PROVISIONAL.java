public class Solution {

    public class Graph {
        Map<Integer, Node> nodes;

        public Graph(int size) {
          this.nodes = new HashMap<Integer, Node>();
          for (int i = 1; i <= size; i++) {
            this.nodes.put(i, new Node(i));
          }
        }

        public void addEdges(ArrayList<ArrayList<Integer>> B) {
            for (ArrayList<Integer> edge : B) {
              this.nodes.get(edge.get(0)).neighbors.put(edge.get(1), new Edge(edge.get(0), edge.get(1), edge.get(2)));
              this.nodes.get(edge.get(1)).neighbors.put(edge.get(0), new Edge(edge.get(1), edge.get(0), edge.get(2)));
            }
        }

        public void addEdge(Edge e) {
          this.nodes.get(e.from).neighbors.put(e.to, e);
          this.nodes.get(e.to).neighbors.put(e.from, e);
        }

        public void removeEdge(Edge e) {
          this.nodes.get(e.from).neighbors.remove(e.to);
          this.nodes.get(e.to).neighbors.remove(e.from);
        }

        public ArrayList<Edge> getAllEdges() {
            ArrayList<Edge> res = new ArrayList<Edge>();
            for (int i = 1; i <= this.nodes.size(); i++) {
                for (Integer key : this.nodes.get(i).neighbors.keySet()) {
                    if (key > i) {
                        res.add(this.nodes.get(i).neighbors.get(key));
                    }
                }
            }

            Collections.sort(res, EdgeWeightComparator);

            return res;
        }

        public boolean hasCycle() {
            boolean[] visited = new boolean[this.nodes.size()+1];
            for (int i = 1; i <= this.nodes.size(); i++) {
                if (!visited[i]) {
                    if (dfs(i, visited, -1)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean dfs(int node, boolean[] visited, int parent) {
            visited[node] = true;

            for (Integer x : this.nodes.get(node).neighbors.keySet()) {

                if (!visited[x]) {
                    if (dfs(x, visited, node)) {
                        return true;
                    }
                } else if (x != parent) {
                    return true;
                }

            }

            return false;
        }

    }

    public class Node {
        int label;
        Map<Integer, Edge> neighbors;

        public Node(int label) {
          this.label = label;
          this.neighbors = new HashMap<Integer, Edge>();
        }
    }

    public class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static Comparator<Edge> EdgeWeightComparator = new Comparator<Edge>() {
        public int compare(Edge e1, Edge e2) {
            Integer w1 = e1.weight;
            Integer w2 = e2.weight;

            return w1.compareTo(w2);
        }
    };

    public static Comparator<ArrayList<Integer>> EdgeWeightComparator2 = new Comparator<ArrayList<Integer>>() {
        public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
            Integer w1 = a1.get(2);
            Integer w2 = a2.get(2);

            return w1.compareTo(w2);
        }
    };

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        if (B.size() == A-1) {
            int res = 0;
            for (int i = 0; i < B.size(); i++) {
                res += B.get(i).get(2);
            }

            return res;
        }

        //Graph graph = new Graph(A);
        //graph.addEdges(B);

        //ArrayList<Edge> allEdges = graph.getAllEdges();
        Collections.sort(B, EdgeWeightComparator2);

        Graph mst = new Graph(A);
        int minCost = 0;

        for (ArrayList<Integer> e : B) {
          Edge edge = new Edge(e.get(0), e.get(1), e.get(2));
          mst.addEdge(edge);
          if (mst.hasCycle()) {
            mst.removeEdge(edge);
          } else {
            minCost += edge.weight;
          }
        }
/*
        for (int i = 0; i < allEdges.size(); i++) {
          Edge e = allEdges.get(i);
          mst.addEdge(e);
          if (mst.hasCycle()) {
            mst.removeEdge(e);
          } else {
            minCost += e.weight;
          }
        }
*/
        return minCost;
    }

    private boolean hasCycle(int A, Map<Integer, Map<Integer, Edge>> mst) {
        boolean[] visited = new boolean[A+1];
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1, mst)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node, boolean[] visited, int parent, Map<Integer, Map<Integer, Edge>> mst) {
        visited[node] = true;

        for (Integer x : mst.get(node).keySet()) {

            if (!visited[x]) {
                if (dfs(x, visited, node, mst)) {
                    return true;
                }
            } else if (x != parent) {
                return true;
            }

        }

        return false;
    }


    private ArrayList<Edge> getAllEdges(int A, Map<Integer, Map<Integer, Edge>> graph) {
        ArrayList<Edge> res = new ArrayList<Edge>();
        for (int i = 1; i <= A; i++) {
            for (Integer key : graph.get(i).keySet()) {
                if (key > i) {
                    res.add(graph.get(i).get(key));
                }
            }
        }

        Collections.sort(res, EdgeWeightComparator);

        return res;
    }

    private boolean hasEdge(int A, Map<Integer, Map<Integer, Edge>> graph, int u, int v) {
        for (Integer x : graph.get(u).keySet()) {
            if (x == v) {
                return true;
            }
        }

        return false;
    }

    private int minKey(int A, int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minInd = -1;
        for (int v = 1; v <= A; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minInd = v;
            }
        }

        return minInd;
    }

    private Map<Integer, Map<Integer, Edge>> buildGraph(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, Map<Integer, Edge>> graph = new HashMap<Integer, Map<Integer, Edge>>();
        for (int i = 1; i <= A; i++) {
            graph.put(i, new HashMap<Integer, Edge>());
        }

        for (ArrayList<Integer> edge : B) {
            graph.get(edge.get(0)).put(edge.get(1), new Edge(edge.get(0), edge.get(1), edge.get(2)));
            graph.get(edge.get(1)).put(edge.get(0), new Edge(edge.get(1), edge.get(0), edge.get(2)));
        }

        return graph;
    }

    private int[][] buildCostMatrix(int A, ArrayList<ArrayList<Integer>> B) {
        int[][] costMatrix = new int[A+1][A+1];
        for (ArrayList<Integer> edge : B) {
            costMatrix[edge.get(0)][edge.get(1)] = edge.get(2);
            costMatrix[edge.get(1)][edge.get(0)] = edge.get(2);
        }

        return costMatrix;
    }
}

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map =
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        q.add(node);
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);

        while (!q.isEmpty()) {
            UndirectedGraphNode currNode = q.remove();
            ArrayList<UndirectedGraphNode> currNeighbors = (ArrayList<UndirectedGraphNode>)currNode.neighbors;

            for (UndirectedGraphNode aNeighbor : currNeighbors) {
                if (!map.containsKey(aNeighbor)) {
                    UndirectedGraphNode aCopyNeighbor = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor, aCopyNeighbor);
                    map.get(currNode).neighbors.add(aCopyNeighbor);
                    q.add(aNeighbor);
                } else {
                    map.get(currNode).neighbors.add(map.get(aNeighbor));
                }
            }
        }

        return copyNode;
    }
}

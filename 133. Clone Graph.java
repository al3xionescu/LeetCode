/*
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

Example:

Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
*/

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if (root == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(root);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,
        UndirectedGraphNode>();
        map.put(root, new UndirectedGraphNode(root.label));
        while(!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            for (UndirectedGraphNode neigh : node.neighbors) {
                if (!map.containsKey(neigh)) {
                    map.put(neigh, new UndirectedGraphNode(neigh.label));
                    queue.add(neigh);
                }
                map.get(node).neighbors.add(map.get(neigh));
            }
        }
        return map.get(root);
    }
}

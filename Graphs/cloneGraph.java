import java.util.HashMap;

import org.w3c.dom.Node;

public class cloneGraph {
    private Node cloneUtil(Node node, HashMap<Node, Node> map) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node neighbour: node.neighbors) {
            if(!map.containsKey(neighbour)) {
                newNode.neighbors.add(cloneUtil(neighbour, map));
            } else {
                newNode.neighbors.add(map.get(neighbour));
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        return cloneUtil(node, map);
    }
}

public class Solution {
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for (UndirectedGraphNode nbr : node.neighbors) {
            clone.neighbors.add(clone(nbr));
        }
        
        return clone;
    }
}

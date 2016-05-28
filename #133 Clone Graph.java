import java.util.*;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Hashtable<Integer, UndirectedGraphNode> table = new Hashtable<>();

        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        queue.offer(node);
        table.put(res.label, res);

        while(!queue.isEmpty()){
            UndirectedGraphNode tmp = queue.poll();
            UndirectedGraphNode resTmp = table.get(tmp.label);

            for(UndirectedGraphNode i : tmp.neighbors){
                if(!table.containsKey(i.label)) {
                    UndirectedGraphNode addNode = new UndirectedGraphNode(i.label);
                    table.put(addNode.label, addNode);
                    queue.offer(i);
                }
                resTmp.neighbors.add(table.get(i.label));
            }
        }

        return res;
    }
}

import java.util.*;

public class Solution {
    public List<String> findItinerary(String[][] tickets) {

        LinkedList<String> res = new LinkedList<>();
        if(tickets == null || tickets.length < 1)
            return res;

        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for(int i = 0; i < tickets.length; i++)
            if(map.containsKey(tickets[i][0]))
                map.get(tickets[i][0]).add(tickets[i][1]);
            else {
                LinkedList<String> adj = new LinkedList<>();
                adj.add(tickets[i][1]);
                map.put(tickets[i][0], adj);
            }

        for(LinkedList<String> adj : map.values())
            Collections.sort(adj);

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while(!stack.isEmpty()){
            while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
                stack.push(map.get(stack.peek()).removeFirst());
            res.add(0, stack.pop());
        }

        return res;

    }
}

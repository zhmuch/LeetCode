import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        LinkedList<Integer> res = new LinkedList<>();
        
        if(k < 1)
            return res;
        
        Hashtable<Integer, Integer> sta = new Hashtable<>();

        for(int i = 0; i < nums.length; i++){
            if(sta.containsKey(nums[i]))
                sta.put(nums[i], sta.get(nums[i]) + 1);
            else
                sta.put(nums[i], 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return sta.get(o2) - sta.get(o1);
            }
        });

        Iterator<Integer> iterator = sta.keySet().iterator();
        while (iterator.hasNext())
            queue.add(iterator.next());

        for(int i = 0; i < k; i++)
            res.add(queue.poll());

        return res;
    }
}

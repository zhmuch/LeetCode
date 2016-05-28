import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] adjLists = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++)
            adjLists[i] = new LinkedList<>();

        if(prerequisites != null)
            for(int[] i : prerequisites)
                adjLists[i[1]].add(i[0]);
        else
            return true;

        int[] stats = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
            if(stats[i] == 0){
                Stack<Integer> stack = new Stack<>();
                stack.add(i);

                stats[i] = 1;
                if(adjLists[i] != null)
                    for(int j : adjLists[i]){
                        if(stats[j] == 1)
                            return false;
                        else
                            stack.add(j);
                    }

                while(!stack.isEmpty()){
                    int t = stack.peek();

                    if(stats[t] == 0){
                        stats[t] = 1;
                        if(adjLists[i] != null)
                            for(int j : adjLists[t]){
                                if(stats[j] == 1)
                                    return false;
                                else
                                    stack.add(j);
                            }
                    } else {
                        stats[t] = 2;
                        stack.pop();
                    }
                }
            }

        return true;
    }
}

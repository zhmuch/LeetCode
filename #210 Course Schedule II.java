//  Same as #207;
//  Topological Sort!!!!!!

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] notExi = new int[0];

        LinkedList<Integer>[] adjLists = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++)
            adjLists[i] = new LinkedList<>();

        for(int[] i : prerequisites)
            adjLists[i[1]].add(i[0]);

        int[] stats = new int[numCourses];
        int[] res = new int[numCourses];
        int idx = numCourses - 1;

        for(int i = 0; i < numCourses; i++)
            if(stats[i] == 0){
                Stack<Integer> stack = new Stack<>();
                stack.add(i);

                stats[i] = 1;
                if(adjLists[i] != null)
                    for(int j : adjLists[i]){
                        if(stats[j] == 1)
                            return notExi;
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
                                    return notExi;
                                else
                                    stack.add(j);
                            }
                    } else {
                        if(stats[t] == 1){
                            res[idx] = t;
                            idx--;
                        }
                        stats[t] = 2;
                        stack.pop();
                    }
                }
            }

        return res;
    }
}

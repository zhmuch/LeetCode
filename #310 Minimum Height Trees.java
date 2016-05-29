//  Other`s;
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if(n <= 1) {
            return Collections.singletonList(0);
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();     // list of edges to  Ajacency Lists
        
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves) {
                for(int newLeaf : graph.get(leaf)) {
                    graph.get(leaf).remove(newLeaf);
                    graph.get(newLeaf).remove(leaf);
                    if(graph.get(newLeaf).size() == 1) {
                        newLeaves.add(newLeaf);
                    }
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}


//  Bellman-Ford Algorithm;
//  Time Limit Exceeds;
import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        //  Initialization;
        int[][] edge = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                edge[i][j] = Integer.MAX_VALUE / 2;
        for(int i = 0; i < n; i++)
            edge[i][i] = 0;

        for(int[] i : edges){
            edge[i[0]][i[1]] = 1;
            edge[i[1]][i[0]] = 1;
        }

        //  Bellman-Ford
        int m = 1;
        while(m < n - 1){
            int[][] newEdge = new int[n][n];

            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++){
                    newEdge[i][j] = Integer.MAX_VALUE / 2;
                    for(int k = 0; k < n; k++)
                        newEdge[i][j] = Math.min(newEdge[i][j], edge[i][k] + edge[k][j]);
                }

            edge = newEdge;
            m *= 2;
        }

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++)
//                System.out.print(edge[i][j] + " ");
//            System.out.println();
//        }

        List<Integer> res = new LinkedList<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int max = 0;
            for(int j = 0; j < n; j++)
                max = Math.max(max, edge[i][j]);

            if(max < min){
                res.clear();
                res.add(i);
                min = max;
            } else if(max == min)
                res.add(i);
        }

        return res;
    }
}

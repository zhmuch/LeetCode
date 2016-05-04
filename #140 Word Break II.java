//  Decide whether there exist such break first, then go into generate();
//  Maybe DP will get better performance;
import java.util.*;

public class Solution {
    LinkedList<String> res;
    String s;
    Set<String> wordDict;
    boolean[][] mat;

    public List<String> wordBreak(String s, Set<String> wordDict) {

        this.res = new LinkedList<>();
        this.s = s;
        this.wordDict = wordDict;

        int len = s.length();

        this.mat = new boolean[len + 1][len + 1];

        for(String tmp : wordDict){
            int tmpLen = tmp.length();
            for(int i = 0; i <= len - tmpLen; i++){
                boolean match = true;

                for(int j = 0; j < tmpLen; j++)
                    if(s.charAt(i + j) != tmp.charAt(j)){
                        match = false;
                        break;
                    }

                if(match)
                    mat[i][i + tmpLen] = true;
            }
        }



//        System.out.println("Done!");

        boolean[] valid = new boolean[len + 1];
        valid[0] = true;

        for(int i = 0; i <= len; i++){
            for(int j = i + 1; j <= len; j++)
                if(valid[i] && mat[i][j])
                    valid[j] = true;
        }

        if(valid[len]){
//            System.out.println("valid!");
            generate(0, "");
        }

        return res;
    }

    //  DFS;
    private void generate(int start, String curr) {
//        System.out.println("Curr: " + curr);

        if(start == s.length()){
            curr = curr.trim();
            res.add(curr);
            return;
        }

        for(int i = start + 1; i <= s.length(); i++)
            if(mat[start][i]){
                String tmp = curr + " " + s.substring(start, i);
                generate(i, tmp);
            }

    }
}


//  TLE...

public class Solution {
    LinkedList<String> res;
    String s;
    Set<String> wordDict;
    boolean[][] mat;
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        
        this.res = new LinkedList<>();
        this.s = s;
        this.wordDict = wordDict;
        
        int len = s.length();
        
        this.mat = new boolean[len + 1][len + 1];
        
        for(String tmp : wordDict){
            int tmpLen = tmp.length();
            for(int i = 0; i <= len - tmpLen; i++){
                boolean match = true;
                
                for(int j = 0; j < tmpLen; j++)
                    if(s.charAt(i + j) != tmp.charAt(j)){
                        match = false;
                        break;
                    }
                
                if(match)
                    mat[i][i + tmpLen] = true;
            }
        }
        
        generate(0, "");
        
        return res;
    }
    
    //  DFS;
    private void generate(int start, String curr) {
        
        if(start == s.length()){
            curr = curr.trim();
            res.add(curr);
            return;
        }
        
        for(int i = start + 1; i <= s.length(); i++)
            if(mat[start][i]){
                String tmp = curr + " " + s.substring(start, i);
                generate(i, tmp);
            }
        
    }
}

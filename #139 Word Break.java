//  Dynamic Programming;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {

        if(s == null || wordDict == null || wordDict.size() < 1)
            return false;

        int l = s.length();
        boolean[] dp = new boolean[l];
        
        int maxLen = 0;
        for(String tmp : wordDict)
            maxLen = Math.max(maxLen, tmp.length());
        
        for(int i = 0; i < l; i++){
            for(int j = 0; j <maxLen; j++){
                int start = i - j;
                if(start < 0)
                    break;
                
                String tmp = s.substring(start, i + 1);
                
                if ((start == 0 || dp[start - 1]) && wordDict.contains(tmp)){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[l - 1];

    }
}

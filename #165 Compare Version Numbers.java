public class Solution {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for(int i=0; i<Math.min(v1.length, v2.length); i++){
            int p1 = gen(v1[i]);
            int p2 = gen(v2[i]);
            
            if(p1 == p2)
                continue;
            else
                return (p1 > p2) ? 1 : -1;
        }

        if(v1.length > v2.length){
            int i = v2.length;
            while(i < v1.length){
                if(gen(v1[i]) == 0)
                    i++;
                else
                    return 1;
            }
        }
            
        else if(v1.length < v2.length){
            int j = v1.length;
            while(j < v2.length){
                if(gen(v2[j]) == 0)
                    j++;
                else
                    return -1;
            }
        }
    
        return 0;
    }

    private int gen(String s){

        int res = 0;

        if(s.length() != 0)
            for(int i=0; i<s.length(); i++)
                res = 10 * res + s.charAt(i) - '0';

        return res;

    }
}

//  Use the property of Gray Code;
//  翻转生成格雷码;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n < 0)
            return res;

        res.add(0);
        if(n == 0)
            return res;
        
        res.add(1);
        int bound = 1;
        for(int i = 2; i <= n; i++){
            bound *= 2;
            for(int j = bound - 1; j>=0; j--)
                res.add(bound + res.get(j));
        }

        return res;
    }
}

public class Solution {
    public int[] countBits(int num) {
        if(num < 0)
            return null;

        int[] res = new int[num + 1];
        int i = 1;
        int bound = 2;
        
        while(i <= num){
            if(i == bound)
                bound *= 2;
            res[i] = res[i - bound / 2] + 1;
            i++;
        }

        return res;
    }
}

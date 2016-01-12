public class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        int count = 0;
        int i = l-1;
        while(i>=0 && digits[i] == 9){
            digits[i]=0;
            count++;
            i--;
        }

        if (count==l){
            int[] result = new int[l+1];
            result[0] = 1;
            for(int j=1; j<result.length; j++){
                result[j] = 0;
            }
            return result;
        }
        else{
            digits[i]++;
            return digits;
        }
    }
}

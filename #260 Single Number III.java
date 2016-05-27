/**
 * 1. Use XOR to store the difference among these numbers, if XOR all elements, the result is the difference between two number like result = 3^5 then 3^result = 5 , 5^ result = 3
 * 2. Find one digit 1 in the result, which can be used to distinguish 3 and 5. depends on this, XOR elements will be equal to 3^result = 5 , 5^ result = 3
 * O(n) use constant space
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        
        int[] res = new int[2];  
        int result = nums[0];  
        for(int i=1;i<nums.length;i++){  
            result = result^nums[i];  
        }  
        res[0] = 0;  
        res[1] = 0;  
        int n = result & (~(result-1));  
        for(int i=0;i<nums.length;i++){  
            if((n & nums[i])!=0){  
                res[0] = res[0] ^ nums[i];  
            }else {  
                res[1] = res[1] ^ nums[i];  
            }  
        }  
        return res; 
        
    }
}

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int bottom, upper;
        List<String> sum = new LinkedList<String>();
        int l = nums.length;
        
        if (nums.length == 0) {
            return sum;
        }
        if (nums.length == 1) {
        	sum.add("" + nums[0]);
        	return sum;
        }
        
        bottom = nums[0];
        upper = nums[0];

        for (int i=1; i<l; i++){
        	if (nums[i]-nums[i-1] == 1){
        		upper = nums[i];
        	}
        	else {
        			if (upper == bottom) {
        				sum.add("" + upper);
        			}
        			else{
        				sum.add("" + bottom + "->" + upper); 
        			}	 
        			bottom = nums[i];
        			upper = nums[i];
        	}

        }
        
        if (upper == bottom) {
    		sum.add("" + upper);
        }
        else{
        	sum.add("" + bottom + "->" + upper); 
        }

        return sum;
    }
}

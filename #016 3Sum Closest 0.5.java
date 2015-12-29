/*
  Modified from #015 3Sum.
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int l = nums.length;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int min = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int i = 0;

        while(i<l-2){
            if (nums[i] + nums[i+1] + nums[i+2] - target >= min) return result;
            int down = i+1;
            int up = l-1;

            while(down<up){
                int distance = Math.abs(nums[i] + nums[down] + nums[up] - target);
                if (distance < min){
                    result = nums[i] + nums[down] + nums[up];
                    min = distance;
                }
                if (nums[i] + nums[down] + nums[up] - target < 0) {
                    down++;
                    while (nums[down-1] == nums[down] && down < up) down++;
                } else {
                    up--;
                    while (nums[up+1] == nums[up] && down < up) up--;
                }
            }

            if (min == 0) return result;
            i++;
            while (i<l-2 && nums[i-1] == nums[i]) i++;
        }
        return result;
    }
}

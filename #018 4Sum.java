/*
  Modified from 3Sum.
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        int l = nums.length;
        if (l<4) return result;
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] + nums[3] >target || nums[l-1] + nums[l-2] + nums[l-3] +nums[l-4] <target) return result;
        int i = 0;

        while (i<l-3 && (double)nums[i] - (((double)target)/4) <=0 ){
            int begin = i+1;
            int end = l-1;
            int temptarget = target - nums[i];

            threeSum(result, nums, begin, end, temptarget);
            i++;
            while(i<l-3 && nums[i] == nums[i-1]) i++;
        }
        return result;
    }

    public void threeSum(List<List<Integer>> result, int[] nums, int begin, int end, int target) {
        int l = end-begin+1;
        if (l<3) return;
        
        int[] tnums = new int[l];
        for (int i=0; i<l; i++){
            tnums[i] = nums[begin + i];
        }

        int i = 0;

        while (i<l-2 && (double)tnums[i] - (((double)target)/3) <=0) {
            int down = i+1;
            int up = l-1;
            while (down < up) {
                if (tnums[i] + tnums[down] + tnums[up] == target){
                    List<Integer> res = new LinkedList<Integer>();
                    res.add(nums[begin-1]);
                    res.add(tnums[i]);
                    res.add(tnums[down]);
                    res.add(tnums[up]);
                    result.add(res);

                    down++;
                    up--;
                    while (tnums[down-1] == tnums[down] && down < up) down++;
                    while (tnums[up+1] == tnums[up] && down < up) up--;
                }
                else if (tnums[i] + tnums[down] + tnums[up] > target) {
                    up--;
                } else {
                    down++;
                }
            }
            i++;
            while (i<l-2 && tnums[i-1] == tnums[i]) i++;
        }
    }
}

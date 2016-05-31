//  Naive Array Implementation;
//  TLE for stupid large input;

public class NumArray{

    int[] sums;
    int[] nums;

    public NumArray(int[] nums) {
        if(nums == null || nums.length < 1)
            return;
        
        this.nums = nums;
        
        sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            sums[i] = sums[i - 1] + nums[i];
    }

    void update(int i, int val) {
        int dif = val - nums[i];
        nums[i] = val;
        
        for(int j = i; j < nums.length; j++)
            sums[j] += dif;
    }

    public int sumRange(int i, int j) {
        return sums[j] - sums[i];
    }
}

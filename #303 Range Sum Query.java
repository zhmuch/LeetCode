public class NumArray {
    int[] sums;
    int l;

    public NumArray(int[] nums) {
        this.l = nums.length;
        if(l != 0){
            sums = new int[l + 1];

            sums[0] = 0;
            sums[1] = nums[0];
            for(int i = 2; i <= l; i++)
                sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if(l != 0)
            return sums[j + 1] - sums[i];
        else
            return 0;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

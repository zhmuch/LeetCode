//  Standard Solution;
//  Other`s;

public class NumArray {  
  
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
    
    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }
    
    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
               sum += tree[l];
               l++;
            }
            if ((r % 2) == 0) {
               sum += tree[r];
               r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
    
}  



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

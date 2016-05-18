public class Solution {
    private int[] nums;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        
        if(nums == null || nums.length <= 0)
            return null;
        else
            return generateBSY(0, nums.length - 1); 
    }
    
    private TreeNode generateBSY(int left, int right) {
        if(right < left)
            return null;
        else{
            int mid = (left + right) / 2;
            TreeNode newAdd = new TreeNode(nums[mid]);
            newAdd.left = generateBSY(left, mid - 1);
            newAdd.right = generateBSY(mid + 1, right);
            return newAdd;
        }
    }
}

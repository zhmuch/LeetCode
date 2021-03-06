/*
  Priority Heap.
*/
...


/*
  SELECTION().
  Randomized Partition
  O(n)
*/ 
...


/*
  Sort. O(nlgn).
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

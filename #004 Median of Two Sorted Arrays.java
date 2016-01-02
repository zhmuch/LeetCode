/*
  .length() method is slow, try to avoid using it.
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 1){
            return findKthElement(nums1, 0, nums2, 0, (m + n)/2 + 1);
        }
        else {
            return (findKthElement(nums1, 0, nums2, 0, (m + n)/2) + findKthElement(nums1, 0, nums2, 0, (m + n)/2 + 1)) / 2.0;
        }
    }

    public double findKthElement(int[] nums1, int nums1s, int[] nums2, int nums2s, int k){
        int m = nums1.length - nums1s;
        int n = nums2.length - nums2s;

        if (m < n) return findKthElement(nums2, nums2s, nums1, nums1s, k);
        // Guarantee that m >= n.

        if (n == 0) {
            System.out.println(nums1[nums1s + k - 1]);
            return nums1[nums1s + k - 1];
        }

        if (k == 1) return Math.min(nums1[nums1s], nums2[nums2s]);

        int k2 = Math.min(k/2, n);
        int k1 = k - k2;

        if (nums1[nums1s + k1 -1] > nums2[nums2s + k2 - 1]) return findKthElement(nums1, nums1s, nums2, nums2s + k2, k1);
        else if (nums1[nums1s + k1 -1] < nums2[nums2s + k2 - 1]) return findKthElement(nums1, nums1s + k1, nums2, nums2s, k2);
        else return nums1[nums1s + k1 -1];
    }
}

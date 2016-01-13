/*
  合并排序，分治思想。
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for(int i=0; i<n; i++){
                nums1[i] = nums2[i];
            }
        }

        int[] result = new int[nums1.length];

        int ind1 = 0;
        int ind2 = 0;
        int indr = 0;

        while(ind1<m && ind2<n){
            if(nums1[ind1]<=nums2[ind2]){
                result[indr] = nums1[ind1];
                ind1++;
            }
            else{
                result[indr] = nums2[ind2];
                ind2++;
            }
            indr++;
        }

        if(ind1==m){
            for(int i=ind2; i<n; i++){
                result[indr] = nums2[i];
                indr++;
            }
        }
        else{
            for(int i=ind1; i<m; i++){
                result[indr] = nums1[i];
                indr++;
            }
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i] = result[i];
        }
    }
}

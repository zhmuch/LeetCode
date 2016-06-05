//  First, find the median of the array input;
//  If tmp > median, put it in the large position;
//  Else, put in the small position;

public class Solution {  
    public int vi(int n, int original) {  
        int virtual = (1+ 2 *original)%(n|1);  
        return virtual;  
    }  
    public void wiggleSort(int[] nums) {  
        int len = nums.length;  
        int median = findMedian(nums);  
        int i=0, j=0, k=nums.length-1;  
        while(j<=k) {  
            if(nums[vi(len,j)]>median) {  
                swap(nums, vi(len,i++), vi(len,j++));  
            }else if(nums[vi(len,j)]<median) {  
                swap(nums, vi(len,k--), vi(len,j));  
            }else{  
                j++;  
            }  
        }  
    }  
    public int findMedian(int[] nums) {  
        int len = nums.length;  
        if(len%2 == 0) {  
            return (findK(nums, len/2, 0, len-1) + findK(nums, len/2-1, 0, len-1))/2;  
        }else {  
            return findK(nums, len/2, 0, len-1);  
        }  
    }  
    public int findK(int[] nums, int k, int s, int e) {  
        if(s>=e) return nums[s];  
        int m = partition(nums, s, e);  
        if(m == k) return nums[m];  
        else if(m<k) {  
            return findK(nums, k, m+1, e);  
        }else {  
            return findK(nums, k, s, m-1);  
        }  
    }  
    public int partition(int[] nums, int i, int j) {  
        int pivot = nums[i];  
        int m = i;  
        int n = i+1;  
        while(n<=j) {  
            if(nums[n]<pivot){  
                swap(nums, ++m, n);  
            }  
            n++;  
        }  
        swap(nums, i,m);  
        return m;  
    }  
    public void swap(int[] nums, int a, int b) {  
        int temp = nums[a];  
        nums[a] = nums[b];  
        nums[b] = temp;  
    }  
}  

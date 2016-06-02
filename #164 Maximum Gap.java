//  桶排序
//  涉及线性时间排序－－－考虑Bucket Sort;
//  Other`s;

public class Solution {
    public int maximumGap(int[] nums) {  
        if(nums.length <2) return 0;  
        if(nums.length ==2) {  
            return Math.abs(nums[0]-nums[1]);  
        }  
        int maxValue = nums[0];  
        int minValue = nums[0];  
        for(int i=1; i<nums.length; i++){  
            maxValue = (maxValue> nums[i])? maxValue:nums[i];  
            minValue = (minValue< nums[i])? minValue:nums[i];  
        }  
        int avGap = (maxValue-minValue) / (nums.length-1);  
        int bucketCount = 0;  
        if(avGap == 0){  
            return maxValue-minValue;  
        }else {  
            bucketCount = (maxValue-minValue) / avGap;  
        }  
        //<min,max>, initiate map  
        List<Node> bucketMap = new ArrayList<>();  
        for(int i=0;i<=bucketCount;i++){  
            bucketMap.add(new Node(Integer.MAX_VALUE, Integer.MIN_VALUE));  
        }  
        //every bucket min&max  
        for(int i=0;i<nums.length;i++){  
            int index = (nums[i]-minValue)/avGap;  
            int tempMax = (bucketMap.get(index).max<nums[i])?nums[i]:bucketMap.get(index).max;  
            int tempMin = (bucketMap.get(index).min>nums[i])?nums[i]:bucketMap.get(index).min;  
            bucketMap.get(index).setValue(tempMin, tempMax);  
//            bucketMap.add(index, new Node(tempMin, tempMax));  
        }  
        //find maximum  
        int maxGap = 0;  
        int maxLeft = bucketMap.get(0).max;  
        for(int i=1;i<=bucketCount;i++){  
            Node n1 = bucketMap.get(i);  
            if(n1.min!=Integer.MAX_VALUE){  
                maxGap = Math.max(maxGap, n1.min-maxLeft);  
                maxLeft = n1.max;  
            }  
        }  
        return maxGap;  
    }  
    class Node {  
        int min;  
        int max;  
        public Node(int min, int max){  
            this.min = min;  
            this.max = max;  
        }  
        public void setValue(int min,int max){  
            this.max = max;  
            this.min = min;  
        }
    }

}

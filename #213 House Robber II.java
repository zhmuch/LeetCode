//  Separate the situations: first include or not.

public class Solution {
    public int rob(int[] nums) {

        int len = nums.length;
        if(len < 1)
            return 0;
        if(len == 1)
            return nums[0];

        int[] matY = new int[len + 1];
        matY[0] = 0;
        matY[1] = nums[0];
        matY[2] = matY[1];

        int[] matN = new int[len + 1];
        matN[0] = 0;
        matN[1] = 0;
        matN[2] = nums[1];

        for(int i = 3; i < len; i++){
            matY[i] = Math.max(matY[i - 1], matY[i - 2] + nums[i - 1]);
            matN[i] = Math.max(matN[i - 1], matN[i - 2] + nums[i - 1]);
        }

        matY[len] = matY[len - 1];
        matN[len] = Math.max(matN[len - 1], matN[len - 2] + nums[len - 1]);

        return Math.max(matY[len], matN[len]);

    }
}

public class Solution {
    public void sortColors(int[] nums) {
        int l = nums.length;
        int red0 = 0;
        int white1 = 0;
        int blue2 = 0;

        for (int i = 0; i < l; i++){
            switch (nums[i])
            {
                case 0: {
                    red0++;
                    break;
                }
                case 1: {
                    white1++;
                    break;
                }
                case 2: {
                    blue2++;
                    break;
                }
            }
        }

        for (int j = 0; j < red0; j++){
            nums[j] = 0;
        }
        for (int j = red0; j < white1 + red0; j++){
            nums[j] = 1;
        }
        for (int j = white1 +red0; j < l; j++){
            nums[j] = 2;
        }
    }
}

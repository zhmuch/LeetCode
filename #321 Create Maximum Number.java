import java.util.*;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[k];
        for(int i = 0; i <= len1 && i <= k; i++){
            if(k - i > len2)
                continue;
            else{
//                System.out.println(i + " " + (k - i));
                int[] tmp = merge(generate(nums1, i), generate(nums2, k - i));
                if(compare(res, tmp))
                    res = tmp;
            }
        }

        return res;
    }

    private int[] merge(int[] tmp1, int[] tmp2){
        int[] res = new int[tmp1.length + tmp2.length];
        int pos1 = 0, pos2 = 0, idx = 0;

        while(pos1 < tmp1.length && pos2 < tmp2.length){

            if(tmp1[pos1] > tmp2[pos2])
                res[idx++] = tmp1[pos1++];
            else if(tmp1[pos1] < tmp2[pos2])
                res[idx++] = tmp2[pos2++];
            else{
                int t1 = pos1, t2 = pos2;
                boolean flag = false;
                while(t1 < tmp1.length && t2 < tmp2.length){
                    if(tmp1[t1] == tmp2[t2]){
                        t1++;
                        t2++;
                    } else if(tmp1[t1] > tmp2[t2]){
                        res[idx++] = tmp1[pos1++];
                        flag = true;
                        break;
                    } else{
                        res[idx++] = tmp2[pos2++];
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    if(t1 == tmp1.length)
                        res[idx++] = tmp2[pos2++];
                    else
                        res[idx++] = tmp1[pos1++];
            }
            // System.out.println("res: " + res[idx - 1]);
        }

        if(pos1 == tmp1.length)
            while(pos2 < tmp2.length)
                res[idx++] = tmp2[pos2++];
        else
            while(pos1 < tmp1.length)
                res[idx++] = tmp1[pos1++];

        return res;
    }

    private boolean compare(int[] res, int[] tmp){
        for(int i = 0; i < res.length; i++){
            if(res[i] < tmp[i])
                return true;
            if(res[i] > tmp[i])
                return false;
        }
        return false;
    }

    private int[] generate(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            while(len > 0 && nums.length - i > k - len && res[len - 1] < nums[i])
                len--;
            if(len < k)
                res[len++] = nums[i];
        }
        return res;
    }
}

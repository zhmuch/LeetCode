//  Concentrate on details!!!
//  tons of little bugs;

import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length < 1)
            return "";

        ArrayList<List<Integer>> lists = new ArrayList<>();
        for(int i : nums)
            lists.add(convertToList(i));

        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> num1, List<Integer> num2) {
                List<Integer> tmp1 = new ArrayList<>();
                List<Integer> tmp2 = new ArrayList<>();

                for(int i : num1){
                    tmp1.add(i);
                    tmp2.add(i);
                }
                int idx = 0;
                for(int i : num2){
                    tmp1.add(i);
                    tmp2.add(idx++, i);
                }

                for(idx = 0; idx < tmp1.size(); idx++)
                    if(tmp1.get(idx) != tmp2.get(idx))
                        return tmp2.get(idx) - tmp1.get(idx);

                return 0;
            }
        };

        Collections.sort(lists, comparator);

        StringBuilder s = new StringBuilder();
        for(List<Integer> i : lists)
            for(Integer j : i)
                s.append(j);

        while(s.length() > 1 && s.charAt(0) == '0')
            s.deleteCharAt(0);

        return s.toString();
    }

    private List<Integer> convertToList(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if(n == 0)
            res.add(0);
        else{
            while(n != 0){
                res.add(0, n % 10);
                n /= 10;
            }
        }
        return res;
    }
}
      

/**
 *  另外的做法
 *  Radix sort！！
 * 
 * 
 */ 
...
...
...
...
...

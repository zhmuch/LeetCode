//  Concentrate on details!!!
//  tons of little bugs;

import java.util.*;

//  Radix Sort;

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length < 1)
            return "";

        ArrayList<List<Integer>> lists = new ArrayList<>();
        for(int i : nums)
            lists.add(convertToList(i));

//        for(List<Integer> i : lists)
//            System.out.println(i);

        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> num1, List<Integer> num2) {

//                System.out.println("num1 " + num1);
//                System.out.println("num2 " + num2);

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

//                if(num1.get(0) != num2.get(0))
//                    return num2.get(0) - num1.get(0);
//                else{
//                    int first = num1.get(0);
//                    int idx = 1;
//
//                    while(num1.size() > idx && num2.size() > idx){
//                        if(num1.get(idx) != num2.get(idx))
//                            return num2.get(idx) - num1.get(idx);
//                        else
//                            idx++;
//                    }
//
//                    System.out.println("idx: " + idx);
//                    System.out.println("first: " + first);
//
//                    if(num1.size() == num2.size())
//                        return 0;
//                    else if(num1.size() > num2.size()){
//                        while(num1.size() > idx && num1.get(idx) == first)
//                            idx++;
//                        if(num1.size() == idx)
//                            return 0;
//                        else
//                            return first - num1.get(idx);
//                    } else {
//                        while (num2.size() > idx && num2.get(idx) == first)
//                            idx++;
//                        if (num2.size() == idx)
//                            return 0;
//                        else
//                            return num2.get(idx) - first;
//                    }
//                }
            }
        };

        Collections.sort(lists, comparator);

//        System.out.println("After Sort: ");
//        for(List<Integer> i : lists)
//            System.out.println(i);


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

//        System.out.println(res);

        return res;
    }
}

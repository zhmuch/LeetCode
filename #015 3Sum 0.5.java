/*
    Trying to solve with HashMap.
*/
import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int l = nums.length;
        int[] pos = new int[l];
        int[] neg = new int[l];
        int pi, ni;
        pi = ni = 0;

        for (int i=0; i<l; i++){
            if (nums[i] > 0) {
                pos[pi] = nums[i];
                pi++;
            }
            if (nums[i] < 0) {
                neg[ni] = nums[i];
                ni++;
            }
        }


        Map posmap = new HashMap();
        int[][] posind = new int[pi][2];
        int posindx = 0;
        for (int i=0; i<pi-1; i++){
            for (int j=i+1; j<pi; j++){
                posind[posindx][0] = i;
                posind[posindx][1] = j;
                posmap.p
            }
        }

        Map map = new HashMap<Integer, List<List<Integer>>>();
//        List<List<Integer>> test = new ArrayList<List<Integer>>();
//        List<Integer> a = new ArrayList<Integer>();
//        a.add(1);
//        a.add(2);
//        List<Integer> b = new ArrayList<Integer>();
//        b.add(1);
//        b.add(2);
//        List<Integer> c = new ArrayList<Integer>();
//        c.add(3);
//        test.add(a);
//        test.add(b);
//        test.add(c);
//        List<List<Integer>> test2 = new ArrayList<List<Integer>>();
//        test2 = removeDuplicate(test);
//        System.out.println(test2);


        return result;
    }

    public static List<List<Integer>> removeDuplicate(List<List<Integer>> list)   {
        HashSet h  =   new  HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}


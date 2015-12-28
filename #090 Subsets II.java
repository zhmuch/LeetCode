/*
  Subsets + removeDuplicate().
  Waited to be optimized.
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int l = nums.length;
        Arrays.sort(nums);
        if (l==0) return result;

        int[] flag = new int[l];
        for (int i=0; i<l; i++){
            flag[i] = 0;
        }
        List<Integer> resultnull = new LinkedList<Integer>();
        result.add(resultnull);

        for (double j=1; j<Math.pow(2,(double)l); j++){
            int i = 0;
            flag[i]++;
            while (flag[i] > 1) {
                flag[i] = 0;
                flag[i+1] ++;
                i++;
            }
            List<Integer> temp = new LinkedList<Integer>();
            for (int k = 0; k<l; k++){
                if (flag[k] == 1) temp.add(nums[k]);
            }
            result.add(temp);
        }
        removeDuplicate(result);
        return result;
    }

    public void removeDuplicate(List<List<Integer>> list){
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
    }
}

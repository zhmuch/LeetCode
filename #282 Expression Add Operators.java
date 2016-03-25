/*
  Trying to use Divide-and-Conquer.
  But fail to pruning, more like to be a complete search.
*/

public class Solution {
    List<String> res = new LinkedList<>();

    public List<String> addOperators(String num, int target) {

        int l = num.length();
        if(l < 1)
            return res;

        String tmp = "";
        generate(num, target, 0, tmp, 0,  false, false);

        return res;
    }

    private void generate(String num, int target, int index, String tmp, int mul, boolean multi, boolean minus){

        if(index == num.length() - 1) {
            if (target == num.charAt(index) - '0')
//                res.add(new String(tmp + num.charAt(index)));
                res.add(tmp + num.charAt(index));
            return;
        }

        int i = index;
        int t = num.charAt(index) - '0';
        tmp = tmp + num.charAt(index);

//        for(i = index; i < num.length(); i++){

            //'+', '-'
            if(!multi) {
                if (minus) {
                    generate(num, target - t, i + 1, tmp + '-', 0, false, true);

                    generate(num, t - target, i + 1, tmp + '+', 0, false, false);
                } else {
                    generate(num, target - t, i + 1, tmp + '+', 0, false, false);

                    generate(num, t - target, i + 1, tmp + '-', 0, false, true);
                }
            }
            else{
                
            }

            t = t * 10 + num.charAt(i + 1) - '0';
//        }
    }
}

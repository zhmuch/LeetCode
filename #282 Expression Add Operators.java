/*
  Other`s work.
*/
public class Solution {
    public List<String> addOperators(String num, int target) {  
        List<String> res = new ArrayList<String>();  
        dfs(num, target, 0, 0, "", res);  
        return res;  
    }  
    public void dfs(String num, int target, long cur, long diff, String temp, List<String> res) {  
        if(cur == target && num.length() == 0) {  
            res.add(temp);  
        }  
        for(int i = 1; i<=num.length(); i++) {  
            String str = num.substring(0, i);  
            if(str.length()>1 && '0' == str.charAt(0)) return;  
            String next = num.substring(i);  
            if(temp.length() >0) {  
                dfs(next, target, Long.parseLong(str) + cur, Long.parseLong(str), temp + "+" +str, res);  
                dfs(next, target, cur - Long.parseLong(str), -Long.parseLong(str), temp + "-" +str, res);  
                dfs(next, target, (cur - diff) + diff * Long.parseLong(str), Long.parseLong(str)*diff, temp + "*" +str, res);  
            } else {  
                dfs(next, target, Long.parseLong(str), Long.parseLong(str), str, res);  
            }  
        }  
    }  
}


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

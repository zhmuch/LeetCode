/*
  Divide-and-Conquer
*/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> res = new LinkedList<>();
        int ind = 0;
        boolean single = true;
        int s = 0;

        while(ind < input.length()){

            if(input.charAt(ind) >= '0' && input.charAt(ind) <= '9'){
                if(single)
                    s = s * 10 + input.charAt(ind) - '0';
            }
            else{
                single = false;

                List<Integer> left = diffWaysToCompute(input.substring(0,ind));
                List<Integer> right = diffWaysToCompute(input.substring(ind+1));

                for(int l:left)
                    for(int r:right)
                        if(input.charAt(ind) == '*')
                            res.add(l * r);
                        else if(input.charAt(ind) == '+')
                            res.add(l + r);
                        else
                            res.add(l - r);

            }

            ind++;

        }

        if(single)
            res.add(s);

        return res;
    }
}

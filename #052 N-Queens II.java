//  Same as #051;

public class Solution {
    int n, count;
    StringBuilder templ;

    public int totalNQueens(int n) {
        this.n = n;
        count = 0;

        if(n < 1)
            return count;

        generate(new ArrayList<>());

        return count;
    }

    private void generate(ArrayList<Integer> curr){
        if(curr.size() == n){
            count++;

            if(n % 2 == 0 || curr.get(0) != n / 2)
                count++;

            return;
        }

        if(curr.size() == 0){
            int mid = (n % 2 == 1) ? n / 2 + 1 : n / 2;
            for(int i = 0; i < mid; i++){
                curr.add(i);
                generate(curr);
                curr.remove(0);
            }
        } else {
            for(int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < curr.size(); j++)
                    if (curr.get(j) == i || curr.size() - j == Math.abs(i - curr.get(j))) {
                        flag = false;
                        break;
                    }
                if (flag) {
                    curr.add(i);
                    generate(curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}

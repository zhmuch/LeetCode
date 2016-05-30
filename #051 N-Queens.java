//  Straight;

public class Solution {
    List<List<String>> res;
    int n;
    StringBuilder templ;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        this.n = n;

        templ = new StringBuilder();
        for(int i = 0; i < n; i++)
            templ.append(".");

        if(n < 1)
            return res;

        generate(new LinkedList<>());

        return res;
    }

    private void generate(LinkedList<Integer> curr){
        if(curr.size() == n){
            LinkedList<String> tmp = new LinkedList<>();
            for(int i = 0; i < n; i++){
                StringBuilder t = new StringBuilder(templ);
                t.replace(curr.get(i), curr.get(i) + 1, "Q");
                tmp.add(t.toString());
            }
            res.add(tmp);
            return;
        }

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
                curr.removeLast();
            }
        }
    }
}

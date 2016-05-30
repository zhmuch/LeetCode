//  对半切;
import java.util.*;

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

        generate(new ArrayList<>());

        return res;
    }

    private void generate(ArrayList<Integer> curr){
        if(curr.size() == n){
            LinkedList<String> tmp = new LinkedList<>();
            for(int i = 0; i < n; i++){
                StringBuilder t = new StringBuilder(templ);
                t.replace(curr.get(i), curr.get(i) + 1, "Q");
                tmp.add(t.toString());
            }
            res.add(tmp);

            if(n % 2 == 0 || curr.get(0) != n / 2) {
                LinkedList<String> rev = new LinkedList<>();
                for(int i = 0; i < n; i++){
                    StringBuilder t = new StringBuilder(templ);
                    t.replace(n - curr.get(i) - 1, n - curr.get(i), "Q");
                    rev.add(t.toString());
                }
                res.add(rev);
            }
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

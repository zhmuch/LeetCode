//  Naive Search;
import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        boolean[][] isP = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++)
            for(int j = i; j < s.length(); j++)
                isP[i][j] = isPalin(s.substring(i, j + 1));

        generate(res, new LinkedList<>(), s, 0, isP);

        return res;
    }

    private void generate(List<List<String>> res, List<String> tmp, String s, int start, boolean[][] isP) {
        if(start >= s.length())
            res.add(new LinkedList<>(tmp));
        else{
            for(int i = start; i < s.length(); i++)
                if(isP[start][i]) {
                    tmp.add(s.substring(start, i + 1));
                    generate(res, tmp, s, i + 1, isP);
                    tmp.remove(tmp.size() - 1);
                }
        }
    }

    private boolean isPalin(String s) {
        if(s.length() < 1)
            return true;
        else{
            for(int i = 0; i < s.length() / 2; i++)
                if(s.charAt(i) != s.charAt(s.length() - i - 1))
                    return false;
        }
        return true;
    }

}

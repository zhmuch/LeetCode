import java.util.*;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int size = words.length;
        List<String> res = new LinkedList<>();
        if(size == 0)
            return res;

        if(maxWidth == 0){
            res.add("");
            return res;
        }
        int left = 0;
        int right = 0;
        int sum = words[0].length();

        while(true){
            if(right == size - 1){
                res.add(genelast(words, left, right, maxWidth));
                return res;
            }

            if(sum + words[right+1].length() + 1 <= maxWidth){
                right++;
                sum += words[right].length() + 1;
            }
            else {
                res.add(generate(words, left, right, maxWidth));
                left = ++right;
                sum = words[left].length();
            }
        }
    }
    String genelast(String[] words, int left, int right, int maxWidth) {
        String res = "";

        for(int i=left; i<right; i++){
            res = res + words[i] + " ";
        }
        res = res + words[right];
        
        int l = res.length();
        for(int i=l; i<maxWidth; i++)
            res = res + " ";
        
        return res;
    }

    String generate(String[] words, int left, int right, int maxWidth) {

        int n = right - left + 1;

        int chars = 0;
        for(int i=left; i<=right; i++)
            chars += words[i].length();
        int spaces = maxWidth - chars;

        int l;              //# num of gaps.
        if(n == 1)
            l = 1;
        else
            l = n - 1;

        int even = spaces / l;
        String e = "";
        for(int i=0; i<even; i++)
            e = e + " ";
        int more = spaces % l;

        String res = "";

        if(n > 1){
            for(int i=0; i<n-1; i++){
                res = res + words[left + i];
                if(i < more)
                    res = res + e + " ";
                else
                    res = res + e;
            }
            res = res + words[right];
        }
        else{
            res = res + words[left];
            res = res + e;
        }

        return res;
    }
}

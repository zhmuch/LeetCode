//  Faster;
public class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() <= 1) {
            return s;
        }
        char[] str = s.toCharArray();
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            while (i < j && !isVowel(str[i])) i++;
            while (i < j && !isVowel(str[j])) j--;
            if (i <= j) swap(str, i, j);
        }
        return new String(str);
    }
    private boolean isVowel(char ch) {
        char c = Character.toLowerCase(ch);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}

//  Standard solution;
import java.util.*;

public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){
    
            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }
    
            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }
    
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
    
            start++;
            end--;
        }
        return new String(chars);
    }
}

//  Stack;
import java.util.*;

public class Solution {
    public String reverseVowels(String s) {
        if (s == null)
            return s;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        StringBuilder tmp = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++)
            if(set.contains(s.charAt(i)))
                stack.push(s.charAt(i));

        for(int i = 0; i < s.length(); i++)
            if(set.contains(s.charAt(i)))
                tmp.append(stack.pop());
            else
                tmp.append(s.charAt(i));

        return tmp.toString();
    }
}


//  大小写！！
//  Very slow;


public class Solution {
    public String reverseVowels(String s) {
        if(s == null)
            return s;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            tmp.append(s.charAt(i));

        int left = 0, right = s.length() - 1;
        while(left < right){
            while(left < s.length() && !set.contains(tmp.charAt(left)))
                left++;
            while(right >= 0 && !set.contains(tmp.charAt(right)))
                right--;

            if(left >= right || left >= s.length() || right < 0)
                break;
                
            char l = tmp.charAt(left);    
            char r = tmp.charAt(right);
        
            tmp.deleteCharAt(left);
            tmp.insert(left, r);
            tmp.deleteCharAt(right);
            tmp.insert(right, l);

            left++;
            right--;
        }

        return tmp.toString();
    }
}

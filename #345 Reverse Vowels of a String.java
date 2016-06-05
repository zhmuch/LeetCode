//  大小写！！


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

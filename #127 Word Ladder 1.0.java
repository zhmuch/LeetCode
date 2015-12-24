// Plain BFS, Time Exceeded

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.equals(endWord) || beginWord.length() != endWord.length())
            return 0;

        int distance = 1;
        int s=0, e=0;
        wordList.add(beginWord);
        wordList.add(endWord);

        String[] words = (String[]) wordList.toArray(new String[0]);
        int l = words.length;
        for (int i=0; i<l; i++){
            if (words[i].equals(beginWord)){
                s=i;
            }
            if (words[i].equals(endWord)){
                e=i;
            }
        }

        int[] flag = new int[l];
        int[] tflag = new int[l];
        int change = 0;
        for (int i=0; i<l; i++){
            flag[i] = 0;
            tflag[i] = 0;
        }
        flag[s] = 1;
        tflag[s] = 1;

//        for (int i = 0; i<l; i++) {
//            System.out.println(words[i]);
//            System.out.println(flag[i]);
//
//        }
        while (flag[e] == 0){
            distance++;
            change = 0;
            for (int i=0; i<l; i++) {
                if (flag[i] == 1) {
                    for (int j = 0; j < l; j++) {
                        if (isAdjacent(words[i], words[j])) {
                            tflag[j] = 1;
                            change = 1;
                        }
                    }
                }
            }
            for (int i=0; i<l; i++){
                flag[i] = tflag[i];
            }
            if (change==0) return 0;
        }
        return distance;
    }

    private boolean isAdjacent(String a, String b){
        int diff = 0;
        for (int i=0; i<a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                diff++;
            }
        }
        return (diff == 1);
    }
}

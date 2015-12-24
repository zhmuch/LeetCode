/*
  BFS Updated from 2.0
  Delete Dist Map, time consuming;
  Delete toString(), time consuming.
  Accepted;
*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.equals(endWord) || beginWord.length() != endWord.length())
            return 0;

        int l = beginWord.length();
        int distance = 1;

        Queue<String> queue=new LinkedList<String>();
        queue.offer(beginWord);
        wordList.remove(beginWord);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String head = queue.poll();
                for (int j = 0; j < l; j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (head.charAt(j) == k) continue;

                        String temp = replace(head, j, k);

                        if (temp.equals(endWord)) return distance+1;

                        if (wordList.contains(temp)){
                            queue.offer(temp);
                            wordList.remove(temp);
                        }
                    }
                }

            }
            distance++;
        }
        return 0;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}

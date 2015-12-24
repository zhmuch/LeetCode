/**
 * Created by Muchen on 12/23/15.
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.equals(endWord) || beginWord.length() != endWord.length())
            return 0;

        wordList.add(beginWord);
        wordList.add(endWord);

//        String[] words = (String[]) wordList.toArray(new String[0]);
        int l = beginWord.length();

//        for (int i = 0; i<l; i++) {
//            System.out.println(words[i]);
//            System.out.println(flag[i]);
//
//        }
        Queue<String> queue=new LinkedList<String>();
        queue.add(beginWord);
        HashMap<String,Integer> dists=new HashMap<String,Integer>();
        dists.put(beginWord, 1);

        while (!queue.isEmpty()) {
//            System.out.println("in while");
            String head = queue.poll();
//            System.out.println("head = " + head);
            int dist = dists.get(head);

            for (int i = 0; i < l; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (head.charAt(i) == j) continue;

                    StringBuilder temp = new StringBuilder(head);
                    temp.setCharAt(i, j);

                    if (temp.toString().equals(endWord)) return dist+1;

                    if (wordList.contains(temp.toString()) && !dists.containsKey(temp.toString())){
                        queue.add(temp.toString());
                        dists.put(temp.toString(), dist+1);
                    }
                }
            }
        }
        return 0;
    }
}

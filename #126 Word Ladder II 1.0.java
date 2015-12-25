/*
  Modified from #125 Word Ladder 3.0
  Constructing directed Map to get transformation sequence
  Time exceeded
*/

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.equals(endWord) || beginWord.length() != endWord.length())
            return null;

        int l = beginWord.length();
        int distance = 1;
        List<List<String>> result = new LinkedList<List<String>>();

        Queue<String> queue=new LinkedList<String>();
        HashMap<String,Queue<String>> father=new HashMap<String,Queue<String>>();
        father.put(beginWord, null);
        queue.offer(beginWord);
        wordList.remove(beginWord);

        boolean flag = false;

        while (!queue.isEmpty()) {
            Queue<String> temps=new LinkedList<String>();       //for remove
            int count = queue.size();

            for (int i = 0; i < count; i++) {
                String head = queue.poll();
                for (int j = 0; j < l; j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (head.charAt(j) == k) continue;

                        String temp = replace(head, j, k);
                        if (temp.equals(endWord)) {
                            flag = true;
                            Queue<String> tfather = new LinkedList<String>();
                            if (father.containsKey(temp)){
                                tfather = father.get(temp);
                                tfather.add(head);
                                father.put(temp,tfather);
                            }
                            else {
                                tfather.add(head);
                                father.put(temp, tfather);
                            }
                        }
                        if (wordList.contains(temp)){
                            queue.offer(temp);
                            temps.offer(temp);

                            Queue<String> tfather = new LinkedList<String>();
                            if (father.containsKey(temp)){
                                tfather = father.get(temp);
                                tfather.add(head);
                                father.put(temp,tfather);
                            }
                            else {
                                tfather.add(head);
                                father.put(temp, tfather);
                            }
                        }
                    }
                }

            }
            distance++;
            while (!temps.isEmpty()) {
                String temp = temps.poll();
                wordList.remove(temp);
            }
            if (flag) break;
        }

        List<String> seq = new LinkedList<String>();
        seq.add(endWord);
        if (flag) {
            findFather(result, father, endWord, beginWord, seq);
        }
        return result;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private void findFather(List<List<String>> result, HashMap<String,Queue<String>> father, String temp, String beginWord, List<String> seq) {
        Queue<String> sfather = new LinkedList<String>();
        while (!father.get(temp).isEmpty()){
            String tfather = father.get(temp).poll();
            seq.add(tfather);
            sfather.add(tfather);   if (!tfather.equals(beginWord)) {
                findFather(result, father, tfather, beginWord, seq);
            }
            else{
                List<String> tseq = new LinkedList<String>();
                for (int i=0; i<seq.size(); i++){
                    tseq.add(0, seq.get(i));
                }
                result.add(tseq);
            }
            seq.remove(tfather);
        }
        father.put(temp,sfather);
    }
}

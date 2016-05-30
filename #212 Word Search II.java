//  A little improvement;
import java.util.*;

public class Solution {
    List<String> res;
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    char[][] board;
    Trie dict;
    int row, col;
    public List<String> findWords(char[][] board, String[] words) {

        res = new LinkedList<>();
        if(board == null)
            return res;
        row = board.length;
        if(row < 1)
            return res;
        col = board[0].length;
        if(col < 1)
            return res;

        this.board = board;

        dict = new Trie();
        for(String s : words)
            dict.insert(s);

        //  Special Case;
        if(dict.root.isWord)
            res.add("");

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++){
                TrieNode node = dict.root;
                if(node.links[board[i][j] - 'a'] != null){
                    StringBuilder s = new StringBuilder();
                    s.append(board[i][j]);
                    node = node.links[board[i][j] - 'a'];
                    dfs(node, s, i, j, -1);
                }
            }

        return res;

    }

    private void dfs(TrieNode node, StringBuilder curr, int row, int col, int direct) {
        String tmp = curr.toString();
//        System.out.println(tmp);
        if(node.isWord){
            node.isWord = false;
            res.add(tmp);
        }

        for(int i = 0; i < 4; i++)
            if(i != 3 - direct){
                int nextRow = row + directions[i][0];
                int nextCol = col + directions[i][1];

                if(nextRow >= 0 && nextRow < this.row && nextCol >= 0 && nextCol < this.col){
                    char c = board[nextRow][nextCol];
                    if(node.links[c - 'a'] != null){
                        curr.append(c);
                        dfs(node.links[c - 'a'], curr, nextRow, nextCol, i);
                        curr.deleteCharAt(curr.length() - 1);
                    }
                }
            }
    }

    class TrieNode {
        // Initialize your data structure here.
        char c;
        boolean isWord;

        TrieNode[] links = new TrieNode[26];

        public TrieNode() {}

        public TrieNode(char c){
            this.c = c;
        }
    }

    public class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if(word == null || word.length() < 1){
                root.isWord = true;
                return;
            }

            TrieNode curr = root;
            int idx = 0;

            while(idx < word.length()){
                char c = word.charAt(idx);
                if(curr.links[c - 'a'] != null)
                    curr = curr.links[c - 'a'];
                else {
                    TrieNode tmp = new TrieNode(c);
                    curr.links[c - 'a'] = tmp;
                    curr = tmp;
                }

                idx++;
            }
            curr.isWord = true;
        }
    }
}





//  Lots of redundant;
import java.util.*;

public class Solution {
    List<String> res;
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    char[][] board;
    Trie dict;
    int row, col;
    public List<String> findWords(char[][] board, String[] words) {

        res = new LinkedList<>();
        if(board == null)
            return res;
        row = board.length;
        if(row < 1)
            return res;
        col = board[0].length;
        if(col < 1)
            return res;

        this.board = board;

        dict = new Trie();
        for(String s : words)
            dict.insert(s);

        //  Special Case;
        if(dict.search(""))
            res.add("");

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++){
                StringBuilder s = new StringBuilder();
                s.append(board[i][j]);
                dfs(s, i, j, -1);
            }

        return res;

    }

    private void dfs(StringBuilder curr, int row, int col, int direct) {
        String tmp = curr.toString();
//        System.out.println(tmp);

        if(!dict.startsWith(tmp))
            return;
        if(dict.search(tmp))
            res.add(tmp);

        for(int i = 0; i < 4; i++)
            if(i != 3 - direct){
                int nextRow = row + directions[i][0];
                int nextCol = col + directions[i][1];

                if(nextRow >= 0 && nextRow < this.row && nextCol >= 0 && nextCol < this.col){
                    curr.append(board[nextRow][nextCol]);
                    dfs(curr, nextRow, nextCol, i);
                    curr.deleteCharAt(curr.length() - 1);
                }
            }
    }

    class TrieNode {
        // Initialize your data structure here.
        char c;
        boolean isWord;

        TrieNode[] links = new TrieNode[26];

        public TrieNode() {}

        public TrieNode(char c){
            this.c = c;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if(word == null || word.length() < 1){
                root.isWord = true;
                return;
            }

            TrieNode curr = root;
            int idx = 0;

            while(idx < word.length()){
                char c = word.charAt(idx);
                if(curr.links[c - 'a'] != null)
                    curr = curr.links[c - 'a'];
                else {
                    TrieNode tmp = new TrieNode(c);
                    curr.links[c - 'a'] = tmp;
                    curr = tmp;
                }

                idx++;
            }
            curr.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if(word == null || word.length() < 1) {
                boolean res = root.isWord;
                if(root.isWord)
                    root.isWord = false;
                return res;
            }
            else{
                TrieNode curr = root;
                int idx = 0;

                while(idx < word.length()){
                    char c = word.charAt(idx);
                    if(curr.links[c - 'a'] != null)
                        curr = curr.links[c - 'a'];
                    else
                        return false;
                    idx++;
                }

                boolean res = curr.isWord;
                if(curr.isWord)
                    curr.isWord = false;
                return res;
            }
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if(prefix == null || prefix.length() < 1){
                boolean ext = false;
                for(int i = 0; i < 26; i++){
                    ext = ext || (root.links[i] != null);
                    if(ext)
                        break;
                }
                return ext;
            }
            else{
                TrieNode curr = root;
                int idx = 0;

                while(idx < prefix.length()){
                    char c = prefix.charAt(idx);
                    if(curr.links[c - 'a'] != null)
                        curr = curr.links[c - 'a'];
                    else
                        return false;
                    idx++;
                }

                boolean ext = false;
                for(int i = 0; i < 26; i++){
                    ext = ext || curr.links[i] != null;
                    if(ext)
                        break;
                }
                return curr.isWord || ext;
            }
        }
    }
}


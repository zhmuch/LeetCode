/**
 * Object[] implementation;
 */

class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean isWord;
    boolean added;

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
        if(word == null || word.length() < 1)
            root.isWord = true;

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
        if(word == null || word.length() < 1)
            return root.isWord;
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

            return curr.isWord;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() < 1){
            boolean ext = false;
            for(int i = 0; i < 26; i++){
                ext = ext || root.links[i] != null;
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



/**
 * HashTable implemention;
 */

  
import java.util.Hashtable;

class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean isWord;
    Hashtable<Character, TrieNode> table = new Hashtable<>();

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
        if(word == null || word.length() < 1)
            root.isWord = true;

        TrieNode curr = root;
        int idx = 0;

        while(idx < word.length()){
            char c = word.charAt(idx);
            if(curr.table.containsKey(c))
                curr = curr.table.get(c);
            else {
                TrieNode tmp = new TrieNode(c);
                curr.table.put(c, tmp);
                curr = tmp;
            }

            idx++;
        }
        curr.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() < 1)
            return true;
        else{
            TrieNode curr = root;
            int idx = 0;

            while(idx < word.length()){
                if(curr.table.containsKey(word.charAt(idx)))
                    curr = curr.table.get(word.charAt(idx));
                else
                    return false;
                idx++;
            }

            return curr.isWord;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() < 1)
            return !root.table.isEmpty();
        else{
            TrieNode curr = root;
            int idx = 0;

            while(idx < prefix.length()){
                if(curr.table.containsKey(prefix.charAt(idx)))
                    curr = curr.table.get(prefix.charAt(idx));
                else
                    return false;
                idx++;
            }

            return curr.isWord || !curr.table.isEmpty();
        }
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

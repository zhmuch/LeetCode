//  Same as #208;

/**
 * Created by Muchen on 5/30/16.
 */
public class WordDictionary {
    private Word root;

    public WordDictionary() {
        root = new Word();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null || word.length() < 1)
            root.isWord = true;

        Word curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.links[c - 'a'] == null){
                Word tmp = new Word(c);
                curr.links[c - 'a'] = tmp;
                curr = tmp;
            } else
                curr = curr.links[c - 'a'];
        }
        curr.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, Word curr) {
        if(idx == word.length())
            return curr.isWord;
        else {
            char c = word.charAt(idx);
            if(c == '.') {
                boolean ext = false;
                for(int i = 0; i < 26; i++)
                    if(curr.links[i] != null) {
                        ext = ext || dfs(word, idx + 1, curr.links[i]);
                        if(ext)
                            break;
                    }
                return ext;
            } else {
                if(curr.links[c - 'a'] == null)
                    return false;
                else
                    return dfs(word, idx + 1, curr.links[c - 'a']);
            }
        }
    }
}

class Word {
    char c;
    boolean isWord;
    Word[] links = new Word[26];

    public Word(){}

    public Word(char c){
        this.c = c;
    }

}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

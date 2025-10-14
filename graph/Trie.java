/**
 * @author wyr on 2025/10/14
 */
class Trie {
    class TrieNode{
        private TrieNode[] children;
        private  boolean isEndOfWord;
        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if (current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null ;
    }

    private TrieNode searchPrefix(String word){
        TrieNode current = root;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (current.children[index] == null){
                return null;
            }
            current = current.children[index];
        }
        return current;
    }
}

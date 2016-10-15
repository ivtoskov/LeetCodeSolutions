class TrieNode {
    private boolean isLeaf;
    private final TrieNode[] children;
    
    // Initialize your data structure here.
    public TrieNode() {
        this.isLeaf = false;
        this.children = new TrieNode[26];
    }
    
    public void insert(String word, int index) {
        if (index == word.length()) {
            isLeaf = true;
        } else {
            int childIndex = word.charAt(index) - 'a';
            if (children[childIndex] == null) {
                children[childIndex] = new TrieNode();
            }
            children[childIndex].insert(word, index + 1);
        }
    }
    
    public boolean search(String word, int index, boolean shouldBeFinal) {
        if (index == word.length()) {
            return shouldBeFinal ? isLeaf : true;
        }
        
        int childIndex = word.charAt(index) - 'a';
        if (children[childIndex] == null) {
            return false;
        }
        return children[childIndex].search(word, index + 1, shouldBeFinal);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word, 0, true);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.search(prefix, 0, false);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

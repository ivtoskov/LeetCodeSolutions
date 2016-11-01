public class WordDictionary {
    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        root.addWord(word, 0);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    private class TrieNode {
        private boolean isLeaf;
        private TrieNode[] children;
        
        private TrieNode() {
            this.isLeaf = false;
            this.children = new TrieNode[26];
        }
        
        private void addWord(String word, int index) {
            if (index == word.length()) {
                isLeaf = true;
            } else {
                int childIndex = word.charAt(index) - 'a';
                if (children[childIndex] == null) {
                    children[childIndex] = new TrieNode();
                }
                children[childIndex].addWord(word, index + 1);
            }
        }
        
        private boolean search(String word, int index) {
            if (index == word.length()) {
                return isLeaf;
            } else {
                if (word.charAt(index) == '.') {
                    for (TrieNode child : children) {
                        if (child != null && child.search(word, index + 1)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return children[word.charAt(index) - 'a'] != null && children[word.charAt(index) - 'a'].search(word, index+ 1);
                }
            }
        }
    }
}

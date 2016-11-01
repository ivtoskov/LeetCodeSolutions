public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        wordList.remove(beginWord);
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, 1));
        
        while (!queue.isEmpty()) {
            String currentWord = queue.peek().word;
            int currentDist = queue.poll().dist;
            if (currentWord.equals(endWord)) {
                return currentDist;
            }
            
            char[] currentWordChars = currentWord.toCharArray();
            for (int i = 0; i < currentWordChars.length; ++i) {
                char tmp = currentWordChars[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    currentWordChars[i] = c;
                    String tmpString = new String(currentWordChars);
                    if (wordList.remove(tmpString)) {
                        queue.add(new Node(tmpString, currentDist + 1));
                    }
                }
                currentWordChars[i] = tmp;
            }
        }
        
        return 0;
    }
    
    private class Node {
        private final String word;
        private final int dist;
        
        private Node(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }
}

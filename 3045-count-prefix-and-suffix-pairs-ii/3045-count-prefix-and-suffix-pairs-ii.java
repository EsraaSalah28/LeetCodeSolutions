class Solution {
    class TrieNode {
        TrieNode[] children;
        int count;  // Count of words ending here instead of list of indices
        
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }
    
    public long countPrefixSuffixPairs(String[] words) {
        TrieNode root = new TrieNode();
        long result = 0;
        
        // Process each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            result += countPairs(root, word);
            insert(root, word);
        }
        
        return result;
    }
    
    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        int len = word.length();
        
        // Insert only if it's both prefix and suffix
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.count++;  // Increment count instead of storing index
    }
    
    private long countPairs(TrieNode root, String word) {
        TrieNode current = root;
        long count = 0;
        int len = word.length();
        
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (current.children[idx] == null) {
                return count;
            }
            current = current.children[idx];
            
            // If there are words ending here
            if (current.count > 0) {
                // Check if the prefix is also a suffix
                String prefix = word.substring(0, i + 1);
                if (word.endsWith(prefix)) {
                    count += current.count;  // Add the count of all matching words
                }
            }
        }
        
        return count;
    }
}
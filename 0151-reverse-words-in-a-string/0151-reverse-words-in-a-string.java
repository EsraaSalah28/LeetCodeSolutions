class Solution {
    public String reverseWords(String s) {
    String reversed = new StringBuilder(s).reverse().toString();
    String[] words = reversed.split(" ");
    StringBuilder res = new StringBuilder();
    for (String word : words) {
        if (word.length() > 0) {
            res.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
    }
    return res.toString().trim();
        
    }
}
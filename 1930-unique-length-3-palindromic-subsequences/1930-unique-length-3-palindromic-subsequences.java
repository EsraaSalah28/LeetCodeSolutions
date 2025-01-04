class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        boolean[][] prefix = new boolean[n][26]; // Prefix array
        boolean[][] suffix = new boolean[n][26]; // Suffix array

        // Build prefix array
        for (int i = 1; i < n; i++) {
            System.arraycopy(prefix[i - 1], 0, prefix[i], 0, 26);
            prefix[i][s.charAt(i - 1) - 'a'] = true;
        }

        // Build suffix array
        for (int i = n - 2; i >= 0; i--) {
            System.arraycopy(suffix[i + 1], 0, suffix[i], 0, 26);
            suffix[i][s.charAt(i + 1) - 'a'] = true;
        }

        // Count unique palindromic subsequences
        Set<String> uniquePalindromes = new HashSet<>();
        for (int mid = 1; mid < n - 1; mid++) {
            char midChar = s.charAt(mid);

            for (char c = 'a'; c <= 'z'; c++) {
                if (prefix[mid][c - 'a'] && suffix[mid][c - 'a']) {
                    uniquePalindromes.add("" + c + midChar + c);
                }
            }
        }

        return uniquePalindromes.size();
    }
}
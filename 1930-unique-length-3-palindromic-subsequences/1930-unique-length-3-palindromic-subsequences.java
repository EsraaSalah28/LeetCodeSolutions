class Solution {
    public int countPalindromicSubsequence(String s) {
     int n = s.length();
        Set<String> uniquePalindromes = new HashSet<>();

        // Iterate through each character as the middle character
        for (int mid = 1; mid < n - 1; mid++) {
            char midChar = s.charAt(mid);

            // Check for matching characters on the left and right
            Set<Character> leftSet = new HashSet<>();
            for (int left = 0; left < mid; left++) {
                if (s.charAt(left) == midChar) {
                    leftSet.add(s.charAt(left));
                }
            }

            // For each character in the left set, check the right side
            for (Character c : leftSet) {
                for (int right = mid + 1; right < n; right++) {
                    if (s.charAt(right) == c) {
                        uniquePalindromes.add("" + c + midChar + c);
                    }
                }
            }
        }

        return uniquePalindromes.size();
    }
}
class Solution {
       public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAllCombinations(result, "", 0, 0, n);
        return result;
    }

    private static void generateAllCombinations(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generateAllCombinations(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generateAllCombinations(result, current + ")", open, close + 1, max);
        }
    }
}
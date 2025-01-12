class Solution {
    public static boolean canBeValid(String s, String locked) {

        Stack<Character> stack = new Stack();
        int n = s.length();
        if (n % 2 != 0)
            return false;
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty()) {
                char c = stack.pop();
                if (c == s.charAt(i)) {
                    if (locked.charAt(i) == '1' && c == '1') {
                        return false;
                    }
                }
            }
            stack.push(s.charAt(i));

        }
        return true;
    }
}
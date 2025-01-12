class Solution {

    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0)
            return false;
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBrackets.isEmpty()) {
                  openBrackets.pop();
                }else if(!unlocked)
                {
                    unlocked.pop();
                }else
                {
                    return true;
                }
            }
        }
        while (
                    !openBrackets.empty() &&
                            !unlocked.empty() &&
                            openBrackets.peek() < unlocked.peek()
            ) {
                openBrackets.pop();
                unlocked.pop();
            }

            if (!openBrackets.empty()) {
                return false;
            }

            return true;
    }
}
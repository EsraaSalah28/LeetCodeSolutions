import static java.lang.Character.*;

class Solution {
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (!stack.isEmpty()) {
                    char lowerCaseCh = Character.toLowerCase(ch);
                    if (stack.peek() == lowerCaseCh) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                } else {
                    stack.push(ch);
                }
            } else {
                if (!stack.isEmpty() && stack.peek() == Character.toUpperCase(ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining(""));
    }


}
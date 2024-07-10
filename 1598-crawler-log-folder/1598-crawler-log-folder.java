class Solution {
    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
          for (String log : logs) {

              if (!log.contains("../") && !log.contains("./")) {
                  stack.push(log);
              } else if (log.equals("../")) {
                  if (!stack.isEmpty()) {
                      stack.pop();
                  }
              }
          }
          return stack.size();
    }

}
class Solution {
      public static void reverse(char[] A , int low, int high) {

        while (low < high) {
            // Swap elements at low and high indices
            char temp = A[low];
            A[low] = A[high];
            A[high] = temp;

            // Move indices towards the center
            low++;
            high--;
        }
    }

   
  // Function to return the modified string 
  static String reverseParentheses(String str) 
  {
    Stack<Integer> st = new Stack<Integer>(); 
    for (int i = 0; i < str.length(); i++)
    {
       
      // Push the index of the current 
      // opening bracket 
      if (str.charAt(i) == '(')
      {
        st.push(i);
      }
       
      // Reverse the substring starting 
      // after the last encountered opening 
      // bracket till the current character 
      else if (str.charAt(i) == ')')
      {
        char[] A = str.toCharArray();
        reverse(A, st.peek() + 1, i);
        str = String.copyValueOf(A);
        st.pop();
      }
    }
     
    // To store the modified string 
    String res = "";
    for (int i = 0; i < str.length(); i++) 
    {
      if (str.charAt(i) != ')' && str.charAt(i) != '(') 
      {
        res += (str.charAt(i)); 
      }
    }
    return res;
  }
}
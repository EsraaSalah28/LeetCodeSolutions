class Solution {
    public static String compressedString(String word) {
     StringBuilder comp =new StringBuilder();
    int count = 1;
        for(int i=1; i<=word.length();i++)
        {
            if(i<word.length()&& word.charAt(i)==word.charAt(i-1))
            {
               count++; 
            }
            else
            {
            while (count > 9) {
                    comp.append("9").append(word.charAt(i - 1));
                    count -= 9;
                }
                 comp.append(count).append(word.charAt(i - 1));
                count = 1;
        }}
 return comp.toString();
    
    }
}
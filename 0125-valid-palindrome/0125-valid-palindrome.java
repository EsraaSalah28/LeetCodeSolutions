class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll("[^0-9a-z]", "");
        int i=0 , j = s.length()-1;
        while(i<=j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
        } 
        
         else
        {
            return false;
        }
        }
       
            
        return true;
        
    }
}
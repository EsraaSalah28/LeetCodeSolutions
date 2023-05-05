class Solution {
    public int countGoodSubstrings(String s) {
        Set<Character> set = new HashSet<>();
        int j =0, count=0;
        for(int i =0; i<s.length();i++)
        {
            while(set.contains(s.charAt(i)))
            {
                set.remove(s.charAt(j));
                    j++;
                
            }
            
            set.add(s.charAt(i));
            if(set.size()==3)
            {
                set.remove(s.charAt(j));
                    j++;
                count++;
            }
        }
        return count;
        
    }
}
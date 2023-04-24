class Solution {
      public static int lengthOfLongestSubstring(String s) {
        int max=0, j=0 , i=0;
        Set<Character> set = new HashSet<>();
        while(j<s.length())
        {
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            }
            else
            {
                set.remove(s.charAt(i++));
            }

        }
        return max;
    }

}
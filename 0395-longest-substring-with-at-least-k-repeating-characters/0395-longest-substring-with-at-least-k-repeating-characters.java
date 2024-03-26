class Solution {
    public int longestSubstring(String s, int k) {
          if (k == 1) return s.length();
            if (s == null || s.length() < k) return 0;
         return helper(s,k,0,s.length());
      
        
    }
    
      public int helper(String s , int k , int start, int end)
        {
          if (end - start < k)
              return 0;
            int countFreq[]= new int[26];
            for(int i=start; i<end;i++){
                countFreq[s.charAt(i)-'a']++; 
            }
            for(int mid=start;mid<end;mid++)
            {
                if(countFreq[s.charAt(mid)-'a']>=k)
                                     continue;

                int midNext=mid+1;
                while(midNext<end && countFreq[s.charAt(midNext)-'a']<k)
                    midNext++;
                return Math.max(helper(s,k,start,mid),helper(s,k,midNext,end));
            }
          return end -start;
        }

}
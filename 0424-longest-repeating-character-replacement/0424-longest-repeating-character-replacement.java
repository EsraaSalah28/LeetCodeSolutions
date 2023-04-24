class Solution {
    public int characterReplacement(String s, int k) {
        int arr [] = new int [26];
        int count =0 , start=0, maxlen=0;
        for(int end=0;end<s.length();end++)
        {
            arr[s.charAt(end)-'A']++;
            count=Math.max(count,arr[s.charAt(end)-'A']);
            if(end-start+1-count>k)
            {   arr[s.charAt(start) - 'A']--;
                start++;
            }
            maxlen = Math.max(maxlen, end - start + 1);
        }
        return maxlen;
    }
}
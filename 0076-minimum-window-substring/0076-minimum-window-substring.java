class Solution {
      public  static String minWindow(String s, String t) {
        String result = "";
        if(s.length() < t.length())
            return result;
        int minWindow = Integer.MAX_VALUE;
        //We will use two variables 'have' & 'need' to keep a track whether the characters
        //we need have been encountered.
        int need = t.length();
        int have = 0;
        //Two hashmaps are used to store the character count.
        Map<Character, Integer> sMap = new HashMap();
        Map<Character, Integer> tMap = new HashMap();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        }
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd<s.length(); windowEnd++){
            char ch = s.charAt(windowEnd);
            sMap.put(ch, sMap.getOrDefault(ch,0)+1);
            //if we have encountered a useful character, we will increment have variable.
            if(tMap.containsKey(ch) && sMap.get(ch)<=(tMap.get(ch))){
                have++;
            }
            //if have is equals to the need, means we got a substring in s having all the character of t
            while(have==need){
                //check if its the mimimum substring till now
                if(minWindow > windowEnd-windowStart+1){
                    minWindow = windowEnd-windowStart+1;
                    result = s.substring(windowStart, windowEnd+1);
                }
                //now we will check, can we do better
                //is there a shorter substring
                char charToRemove = s.charAt(windowStart);
                if(sMap.get(charToRemove) == 1){
                    sMap.remove(charToRemove);
                }else{
                    sMap.put(charToRemove, sMap.get(charToRemove)-1);
                }
                windowStart++;
                //if we remove a useful char, decrementing have varaible
                if(tMap.containsKey(charToRemove) && sMap.getOrDefault(charToRemove,0)<(tMap.get(charToRemove))){
                    have--;
                }
            }
        }
        return result;
    }

}
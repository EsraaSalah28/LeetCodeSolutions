class Solution {
    public int minSteps(String s, String t) {
     char[] st=   s.toCharArray();
             char[] stt=   t.toCharArray();

       HashMap<Character,Integer> map = new HashMap();
          int count =0;
        for(Character ch: st)
        {
            map.put(ch,map.getOrDefault(ch, 0) + 1);
            
        }
           for(Character ch: stt)
        {
           if (!map.containsKey(ch) || map.get(ch) <= 0) {
                count++;
            } else {
                map.put(ch, map.get(ch) - 1);
            }
            
        }
     
        return count++;
        
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
       HashMap<Character, Integer> map = new HashMap<>();
       HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i =0 ;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
         for(int j =0 ;j<t.length();j++)
        {
            map2.put(t.charAt(j),map2.getOrDefault(t.charAt(j),0)+1);
        }
        if(map.equals(map2))
        {
            return true;
        }
        else
        return false;
    }
}
class Solution {
     public static boolean isAlienSorted(String[] words, String order) {
       HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = order.toCharArray();
        for(int i = 0; i < chars.length; i++) {
           map.put(chars[i],i);
       }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], map)) {
                return false;
            }
        }

        return true;
    }
    private static boolean isSorted(String word1, String word2, HashMap<Character, Integer> map) {
        int minLength= Math.min(word1.length(),word2.length());
        for(int i = 0; i < minLength; i++)
        {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if(c1 != c2)
            {
                return map.get(c1) < map.get(c2);
            }
        }
      return word2.length()>=word1.length();

    }
}
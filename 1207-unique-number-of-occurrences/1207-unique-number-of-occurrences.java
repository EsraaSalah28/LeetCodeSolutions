class Solution {
    public static   boolean uniqueOccurrences(int[] arr) {
       HashMap<Integer, Integer> map = new HashMap<>();
       HashSet<Integer> set = new HashSet<>();
       for(int num :arr)
       {
           map.put(num, map.getOrDefault(num, 0) + 1);

       }
       for(int num: map.values())
       {
           if(!set.add(num))
               return false;
       }
     return true;

    }

}
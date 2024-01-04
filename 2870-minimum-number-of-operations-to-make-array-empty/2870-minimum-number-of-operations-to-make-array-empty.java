class Solution {
     public static int minOperations(int[] nums) {
        var map = new HashMap<Integer,Integer>();
        int count =0;
        for(int num :nums)
        {
         map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num : map.values())
        {
            if(num==1)
                return -1;
            count+=Math.ceil((double)num/3);

        }
        return count;

    }
}
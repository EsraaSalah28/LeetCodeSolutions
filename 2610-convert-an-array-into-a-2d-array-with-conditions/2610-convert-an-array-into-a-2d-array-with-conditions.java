class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
    ArrayList<List<Integer>> list = new ArrayList<>();
    int [] freq = new int[nums.length+1];
    for(int num :nums)
    {
        if(freq[num]>=list.size())
        {
            list.add(new ArrayList());
        }
        list.get(freq[num]).add(num);
        freq[num]++;
            
    }
        return list;
    }
}
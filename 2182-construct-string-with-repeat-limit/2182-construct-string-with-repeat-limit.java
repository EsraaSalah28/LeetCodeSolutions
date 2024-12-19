class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map <Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> maxHeap= new  PriorityQueue<>((a,b)
        -> Character.compare(b,a)       );
        
        for(char c :map.keySet())
        {
            maxHeap.offer(c);
        }
       StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty())
        {
             char c=maxHeap.poll();
             int count =map.get(c);
            int use= Math.min(count,repeatLimit );
            for(int i=0 ;i<use;i++)
            {
                result.append(c);
            }
            map.put(c,count-use);
            if(map.get(c)>0&&!maxHeap.isEmpty())
            {
               char nextChar= maxHeap.poll();
                result.append(nextChar);
                map.put(nextChar, map.get(nextChar)-1);
                if(map.get(nextChar)>0)
                {
                   maxHeap.offer(nextChar);

                }
                                   maxHeap.offer(c);

            }
        }
    return result.toString();
    }
}
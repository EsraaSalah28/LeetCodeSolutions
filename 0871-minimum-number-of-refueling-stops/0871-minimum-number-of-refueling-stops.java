class Solution {
     public static int minRefuelStops(int target, int startFuel, int[][] stations) {

       PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int maxDistance=startFuel;
        int n= stations.length;
        int i=0;
        int stops=0;

        if(startFuel>=target)
         return 0;
         while(maxDistance<target)
         {
             if(i<n&&stations[i][0]<=maxDistance)
             {
                 maxHeap.add(stations[i][1]);
                 i++;
             }
             else if(maxHeap.isEmpty())
             {
                 return -1;
             }
             else
             {
               maxDistance+=maxHeap.poll();
               stops++;
             }
         }
        return stops;
    }
}
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        // create adjestment list
        List<List<Integer>> neighbours =  new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            neighbours.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        { if(manager[i]!=-1)
            neighbours.get(manager[i]).add(i);
        }
       
                return dfs(headID, neighbours, informTime);

    }
    
    private int dfs(int current ,List<List<Integer>> neighbours, int[] informTime)
    {
        if(neighbours.get(current).isEmpty())
        {
            return 0;
        }
        int maxTime=0;
        for(int neighbour : neighbours.get(current)){
            maxTime=Math.max(maxTime,dfs(neighbour,neighbours,informTime ) );    
        }
        return maxTime+informTime[current];
        
    }
    
}
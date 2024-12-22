class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjList= new ArrayList[n];
        for(int i=0;i<n;i++)
            adjList[i]=new ArrayList<>();
        
        for(int [] edge :edges)
        {
            int node1= edge[0];
            int node2= edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
           
        }
        int [] componentCount = new int[1];
        
        dfs(0,-1 ,adjList,values,k,componentCount);
        return componentCount[0];
        
    }
    private int dfs (int currentNode , int parentNode , List<Integer>[] adj , int [] values , int k ,int [] componentCount )
    {
        int sum=0;
        for(int neigbour :adj[currentNode])
        {
            if(neigbour!=parentNode){
                sum+=dfs(neigbour,currentNode,adj,values,k,componentCount);
              sum %= k;
            }
        }
        sum+=values[currentNode];
         sum %= k;
         if (sum == 0) {
            componentCount[0]++;
        }
        return sum ;
    }
}
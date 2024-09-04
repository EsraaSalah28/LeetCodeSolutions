class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
         return dfs(0,new ArrayList(),graph);
        
    }
    
List<List<Integer>> dfs(int current, List<Integer> currentPath, int[][] graph)
{   
    currentPath.add(current);
    // base case
    if(current ==graph.length - 1){
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(currentPath));
        return  list;
    }
    
    List<List<Integer>> allPaths =new ArrayList();
    for(int n : graph[current])
    {
        allPaths.addAll(dfs(n,new ArrayList<>(currentPath),graph));
    }
    currentPath.remove(currentPath.size()-1);
    
    return allPaths;
}

}
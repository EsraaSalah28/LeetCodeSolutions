class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        List<Integer> set = new ArrayList();
        dfs(0, set, rooms);
        return set.size()==rooms.size();
        
    }
    
    void dfs(int current , List<Integer> path,List<List<Integer>> rooms)
    {   if (path.contains(current)) {
        return;
    }
        path.add(current);
        
        for(int key : rooms.get(current))
        {
            dfs(key,path,rooms);
        }
    }
}
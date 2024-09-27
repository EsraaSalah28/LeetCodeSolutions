import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
        }
        
        // Priority queue: {cost, city, stops}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, src, 0});  // start with cost 0, source city, and 0 stops
        
        // Track the minimum cost with respect to the number of stops
        int[][] minCost = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        minCost[src][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int city = current[1];
            int stops = current[2];
            
            // If we reach the destination, return the cost
            if (city == dst) {
                return cost;
            }
            
            // If we still have stops left, explore neighbors
            if (stops <= k) {
                if (graph.containsKey(city)) {
                    for (int[] neighbor : graph.get(city)) {
                        int nextCity = neighbor[0];
                        int nextCost = neighbor[1];
                        
                        // If the cost to reach the next city via the current path is cheaper, update and add to pq
                        if (cost + nextCost < minCost[nextCity][stops + 1]) {
                            minCost[nextCity][stops + 1] = cost + nextCost;
                            pq.offer(new int[] {cost + nextCost, nextCity, stops + 1});
                        }
                    }
                }
            }
        }
        
        return -1;
    }

}

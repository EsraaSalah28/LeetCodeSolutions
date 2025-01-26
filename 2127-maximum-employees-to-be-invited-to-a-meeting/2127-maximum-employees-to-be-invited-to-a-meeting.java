class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        for (int p = 0; p < n; p++) {
            inDegree[favorite[p]]++;
        }
        Queue<Integer> q = new LinkedList();
        for (int p = 0; p < n; p++) {
            if (inDegree[p] == 0) {
                q.offer(p);
            }
        }
        int[] depth = new int[n];
        Arrays.fill(depth, 1);
        while (!q.isEmpty()) {
            int curr = q.poll();
            int next = favorite[curr];
            depth[next] = Math.max(depth[next], depth[curr] + 1);
            if (--inDegree[next] == 0) {
                q.offer(next);
            }
        }
        int longestCycle=0;
        int twoCycle=0;
        for(int i=0;i<n ;i++)
        {
            if(inDegree[i]==0)
            continue;
             int cycleLength = 0;
             int current = i;
            while(inDegree[current]!=0)
            {
                inDegree[current]=0;
                cycleLength++;
                current=favorite[current];

            }

         if (cycleLength == 2) {
                    // For 2-cycles, add the depth of both nodes
                    twoCycle += depth[i] + depth[favorite[i]];
                } else {
                    longestCycle = Math.max(longestCycle, cycleLength);
                }
        }

            return Math.max(longestCycle, twoCycle);
    }
}
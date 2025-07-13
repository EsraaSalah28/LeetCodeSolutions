class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int count =0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        for(int i=0;i<players.length;i++)
        {
            for(int j=0;j<trainers.length;j++)
            {
                if(players[i]<=trainers[j])
                {
                    count++;
                    trainers[j]=0;
                    break;
                }
            }
        }
        return count;
        
    }
}
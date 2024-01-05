class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=sum(gas);
        int totalCost=sum(cost);
        int currentGas=0;
        int index=0;
        if(totalGas<totalCost)
            return -1;
        for(int i=0 ;i<gas.length;i++)
        {
            currentGas+=gas[i]-cost[i];
            if(currentGas<0)
            {
            currentGas=0;
                index=i+1;
            }
        }
        return index;
        
        
    }
    
    
    public static int sum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit=0, maxProfit=-1;
      for(int price :prices)
      {
          if(price<min)
          {
              min=price;
          }
              profit=price-min;
          if(profit>maxProfit)
          {
              maxProfit=profit;
          }
      }
        return maxProfit;
        
    }

}
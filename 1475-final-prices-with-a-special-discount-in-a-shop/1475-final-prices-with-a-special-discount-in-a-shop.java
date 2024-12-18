class Solution {
 public static int[] finalPrices(int[] prices) {
    int[] answers = new int[prices.length];
    
    for (int i = 0; i < prices.length; i++) {
        // Initialize the final price as the original price
        answers[i] = prices[i];
        
        // Find the first j > i such that prices[j] <= prices[i]
        for (int j = i + 1; j < prices.length; j++) {
            if (prices[j] <= prices[i]) {
                answers[i] = prices[i] - prices[j];
                break; // Stop once the discount is applied
            }
        }
    }
    
    return answers;
}





}
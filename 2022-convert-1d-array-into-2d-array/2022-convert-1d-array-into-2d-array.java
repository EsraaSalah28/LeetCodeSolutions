class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) 
    {
          if (original.length != m * n) {
        // Return an empty array or null if the conversion is not possible
        return new int[0][0];
    }
        int [][] desmisions= new int [m][n];
        for(int i=0;i<original.length;i++)
        {
           int row=i/n;
            int col =i%n;
            desmisions[row][col]=original[i];
            
        }
        return desmisions;
    }
}
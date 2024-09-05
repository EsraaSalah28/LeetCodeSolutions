class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int old = image[sr][sc];
         if(old==color)
             return image;
        dfs (image,sr,sc,old,color);
          return image;
        
    }
    
    void dfs(int [][] image,  int sr, int sc,int color , int newColor )
    {
          if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        
        image[sr][sc] = newColor;
        
        dfs(image, sr,sc-1,color,newColor);
        dfs(image, sr,sc+1,color,newColor);
        dfs(image, sr-1,sc,color,newColor);
        dfs(image, sr+1,sc,color,newColor);

    }
    
}
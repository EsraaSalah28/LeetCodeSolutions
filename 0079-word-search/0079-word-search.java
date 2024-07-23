class Solution {
  public boolean exist(char[][] board, String word) {
     int rows=board.length;
     int cols=board[0].length;
     for(int i=0;i<rows;i++)
     {
         for (int j=0;j<cols;j++)
         {
             if(dfs(board,word,i,j,0))
             {
                 return true;
             }
         }
     }
     return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        //stop case
        if(index==word.length())
            return true;

        // boundry check
        if(i<0 ||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(index))
               return false;

        // mark as visited

        char visited = board[i][j];
        board[i][j]= '#';

        boolean found = dfs(board,word,i+1,j,index+1)||
        dfs(board,word,i-1,j,index+1)||
        dfs(board,word,i,j-1,index+1)||
        dfs(board,word,i,j+1,index+1);

        board[i][j]=visited;
      return found;
    }
}
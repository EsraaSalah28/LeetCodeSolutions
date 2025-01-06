class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer= new int [n];
        int countLeft=0 , countRight=0, opsLeft=0,opsRight=0;
        for(int i=0;i<n;i++)
        {
           answer[i]+=opsLeft;
           if(boxes.charAt(i)=='1')
            countLeft++;
         opsLeft+=countLeft;
        }
            for (int i = n - 1; i >= 0; i--) {
     
          answer[i]+=opsRight;
          if(boxes.charAt(i)=='1')
          {
            countRight++;
          }
          opsRight+=countRight;
        }
        
       return answer;
        
    }
}
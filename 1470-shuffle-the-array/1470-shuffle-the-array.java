class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans [] = new int [n*2];
        int i=0 , j=n;
        for(int k=0; k<n*2;k=k+2)
        {
            ans[k]= nums[i];
            ans[k+1]=nums[j];
            i++;
            j++;
        }
         return ans ;
    }
}
class Solution {
    public void sortColors(int[] nums) {
        int white =0;
        int red=0;
        int blue=nums.length-1;
        while(white<=blue)
        {
            if(nums[white]==0)
            {
                if(nums[red]!=0)
                {
                    swap(nums,white,red);
                }
                white++;
                red++;
            }
            else if(nums[white]==1)
            {
                white ++;
            }
            else
            {
                if(nums[blue]!=2){
                    swap(nums,white,blue);
                }
                blue--;
            }
            
            
        }    
        
    }
    
    public void swap (int[] colors , int x , int y)
    {
        int temp =colors[x];
        colors[x]=colors[y];
        colors[y]=temp;
        
    }
}
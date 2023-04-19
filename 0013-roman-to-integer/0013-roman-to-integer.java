class Solution {
    public int romanToInt(String s) {
        
        int length= s.length();
        int sum =0, previous=0;
        for(int i = length-1 ; i>=0;i--)
        {
            int current = ConvertSymbolToNum(s.charAt(i));
            
            if (i==length-1)
            {
                sum+=current;
            }
            else{
                if(current<previous)
                {
                    sum=sum-current;
                }
                else{
                    sum+=current;
                }
                
            }
            previous=current;
            
        }
        return sum ;
        
        
        
    }
    
    public int ConvertSymbolToNum(char c){
        int num=0;
        switch(c){
         
            case 'I':
                num =1;
                break;
            case 'V':
                num =5;
                break;
            case 'X':
                num =10;
                break;
            case 'L':
                num =50;
                break;
            case 'C':
                num =100;
                break;
            case 'D':
                num =500;
                break;
            case 'M':
                num =1000;
                break;
            default: 
                num =0;
                break;
                    
        }
    return num ;
    }
}
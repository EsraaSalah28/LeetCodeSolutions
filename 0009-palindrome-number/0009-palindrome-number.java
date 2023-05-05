class Solution {
    public boolean isPalindrome(int x) {
        
        int n=0;
        int a=x;
        while(a>0)
        {
            n=n*10+a%10;
            a=a/10;
        }
        return x==n;
        
    }
}
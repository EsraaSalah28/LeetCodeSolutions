class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
   String first ="" , second="";
    for(int i=0;i<word1.length;i++)
    {
        first+=word1[i];
    }
        for(int j=0;j<word2.length;j++)
        {
            second+=word2[j];
        }
        if(first.equals(second))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
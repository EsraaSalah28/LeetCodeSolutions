class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
     int [] valid=   checkVaildWord(words);
     int n = valid.length;
     int [] prefixSum= new int [n+1];
      prefixSum[0]=0;
      for(int i=1;i<=n;i++){
        prefixSum[i]=prefixSum[i-1]+valid[i-1];
      }
      int ans[]= new int[queries.length];
      for(int i=0;i<queries.length;i++)
      {
        int [] currentQ=queries[i];
           int l = currentQ[0], r = currentQ[1];
            ans[i] = prefixSum[r + 1] - prefixSum[l];
      }
      return ans;

    }

    int [] checkVaildWord(String[] words){
        int n = words.length;
        Set<Character> vowels= Set.of('a','o','i','e','u');
        int [] valid=new int [n];
        for(int i=0;i<n;i++){
            String word =words[i];
             char first=word.charAt(0);
             char last=word.charAt(word.length()-1);
             if(vowels.contains(first)&&vowels.contains(last))
               valid[i]=1;
               else
               valid[i]=0;
        }
        return valid;
    }
}
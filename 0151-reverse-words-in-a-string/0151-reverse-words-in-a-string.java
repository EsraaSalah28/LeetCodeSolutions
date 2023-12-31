class Solution {
    public String reverseWords(String s) {
     String s2= cleanSpaces(s);
     StringBuilder builder = new StringBuilder (s2);
     
       revWord(builder,0,builder.length()-1); 
        int start=0; int end =0; int n = builder.length();
        while(start <n)
        {
            while(end<n && builder.charAt(end)!=' ')
                ++end;
             revWord(builder,start,end-1);
            start=end+1;
            ++end;
        }
  return builder.toString();  
        
}
 
void revWord(StringBuilder sb, int start, int end){
    while(start<end){
    char temp = sb.charAt(start);
    sb.setCharAt(start++, sb.charAt(end));
    sb.setCharAt(end--,temp);
}
}



 String cleanSpaces(String str)
 {
     return str.replaceAll("\\s+"," ").trim();
 }

}
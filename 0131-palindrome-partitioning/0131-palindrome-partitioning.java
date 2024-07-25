class Solution {
    
     public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTracking(s,result, new ArrayList<>(),  0);
        return result;
    }
    
    private static void backTracking(String s, List<List<String>> res, ArrayList<String> tempString, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(tempString));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(isPalindrome(s,index,i)){
                tempString.add(s.substring(index,i+1));
                backTracking(s,res,tempString,i+1);
                tempString.removeLast();

            }

        }
    }


    static boolean isPalindrome(String s, int p1, int p2) {
        while(p1<p2) {
            if(s.charAt(p1++)!=s.charAt(p2--)) {
                return false;
            }
        }
        return true;
    }
}
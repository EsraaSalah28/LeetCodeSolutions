class Solution {
     public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] arr = new int[n];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(A[i]);
            setB.add(B[i]);
            int count=0;
            for(int num :setA)
            {
                if(setB.contains(num))
                    count++;
            }
            arr[i]=count;
        }
         return arr;
    }
}
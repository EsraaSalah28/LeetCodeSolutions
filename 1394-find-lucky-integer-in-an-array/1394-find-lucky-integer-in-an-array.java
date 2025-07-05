import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public static int findLucky(int[] arr) {
        int[] freq = new int[501];
        int max = -1;
        for (int n : arr) {
            freq[n]++;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == i) {
                max = Math.max(max, freq[i]);
            }
        }
        return max;

    }
}
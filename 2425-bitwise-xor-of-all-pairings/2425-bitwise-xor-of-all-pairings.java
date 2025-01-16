class Solution {

    public static int xorAllNums(int[] nums1, int[] nums2) {
        // Compute the XOR of all elements in nums1 and nums2
        int xor1 = 0;
        int xor2 = 0;

        for (int num : nums1) {
            xor1 ^= num;
        }

        for (int num : nums2) {
            xor2 ^= num;
        }

        // Result variable
        int result = 0;

        // Check the parity of the lengths
        if (nums1.length % 2 == 1) {
            result ^= xor2; // nums2 contributes if nums1 has an odd length
        }

        if (nums2.length % 2 == 1) {
            result ^= xor1; // nums1 contributes if nums2 has an odd length
        }

        return result;
    }

}
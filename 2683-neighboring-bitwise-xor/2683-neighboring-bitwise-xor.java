class Solution {
     public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] arr = new int[n];
        arr[0] = 0; // Assume the first element is 0

        // Fill the array based on the XOR logic
        for (int i = 0; i < n - 1; i++) {
            arr[i + 1] = arr[i] ^ derived[i];
        }

        // Check the validity condition
        return (arr[n - 1] ^ derived[n - 1]) == arr[0];
    }
}
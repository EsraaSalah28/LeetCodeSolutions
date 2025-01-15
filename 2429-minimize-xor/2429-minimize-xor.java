class Solution {
  public int minimizeXor(int num1, int num2) {
    int targetBits = countSetBits(num2);
    // Use a helper array to store minXOR and result
    int[] helper = {Integer.MAX_VALUE, 0}; // helper[0] = minXOR, helper[1] = result

    // Generate all x with exactly targetBits set bits
    generateX(0, 0, targetBits, num1, helper);

    return helper[1];
}

private void generateX(int current, int start, int remainingBits, int num1, int[] helper) {
    if (remainingBits == 0) {
        int currentXOR = current ^ num1;
        if (currentXOR < helper[0]) {
            helper[0] = currentXOR; // Update minXOR
            helper[1] = current;   // Update result
        }
        return;
    }

    for (int i = start; i < 30; i++) {
        generateX(current | (1 << i), i + 1, remainingBits - 1, num1, helper);
    }
}

// Helper method to count set bits
private int countSetBits(int num) {
    int count = 0;
    while (num > 0) {
        count += num & 1;
        num >>= 1;
    }
    return count;
}

}
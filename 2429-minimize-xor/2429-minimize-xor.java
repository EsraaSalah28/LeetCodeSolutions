class Solution {
  public int minimizeXor(int num1, int num2) {
    int targetBits = countSetBits(num2);
    int result = 0;

    // Step 1: Use the most significant bits of num1
    for (int i = 31; i >= 0; i--) {
        if ((num1 & (1 << i)) != 0) { // If the ith bit in num1 is set
            result |= (1 << i);       // Set the ith bit in result
            targetBits--;            // Decrease the required set bits
            if (targetBits == 0) break; // Stop if no more bits are needed
        }
    }

    // Step 2: Use the least significant unset bits if more bits are needed
    for (int i = 0; i <= 31 && targetBits > 0; i++) {
        if ((result & (1 << i)) == 0) { // If the ith bit in result is not set
            result |= (1 << i);         // Set the ith bit in result
            targetBits--;              // Decrease the required set bits
        }
    }

    return result;
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
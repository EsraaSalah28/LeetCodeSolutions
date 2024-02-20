class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int k=10;

            int n = s.length();

            // Mapping of characters
            Map<Character, Integer> mapping = new HashMap<>();
            mapping.put('A', 1);
            mapping.put('C', 2);
            mapping.put('G', 3);
            mapping.put('T', 4);

            // Base value
            int a = 4;

            // Numeric representation of the sequence
            List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
            // Arrays.fill(numbers.toArray(), 0);
            for (int i = 0; i < n; i++) {
                numbers.set(i, mapping.get(s.charAt(i)));
            }

            // Current hash value
            int hashValue = 0;

            // 1. Hash set to store the unique hash values
            // 2. Output set to store the repeated substrings
            Set<Integer> hashSet = new HashSet<>();
            Set<String> output = new HashSet<>();

            for (int i = 0; i < n - k + 1; i++) {

                // If the window is at its initial position, calculate the hash value from scratch
                if (i == 0) {
                    for (int j = 0; j < k; j++) {
                        hashValue += numbers.get(j) * (int) Math.pow(a, k - j - 1);
                    }
                } else {
                    int previousHashValue = hashValue;
                    hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(a, k - 1)) * a) + numbers.get(i + k - 1);
                }

                // If the current hash value is present in the hash set, the current substring has been repeated, so we add it to the output
                if (hashSet.contains(hashValue)) {
                    output.add(s.substring(i, i + k));
                }

                // We add the evaluated hash value to the hash set
                hashSet.add(hashValue);


            }
          List<String> mainList = new ArrayList<String>();
 mainList.addAll(output); 
        return mainList;
            
        }
}
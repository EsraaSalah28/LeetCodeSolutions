class Solution {
     public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Sort the words based on frequency and lexicographical order
        List<String> candidates = new ArrayList<>(countMap.keySet());
        Collections.sort(candidates, (w1, w2) -> {
            int freq1 = countMap.get(w1);
            int freq2 = countMap.get(w2);
            if (freq1 == freq2) {
                return w1.compareTo(w2); // Lexicographical order
            }
            return freq2 - freq1; // Descending frequency order
        });

        // Step 3: Select the top k words
        return candidates.subList(0, k);
    }
}
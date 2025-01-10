class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxfreq = new int[26];
        for (String b : words2) {
            int[] freq = countFreq(b);
            for (int i = 0; i < 26; i++) {
                maxfreq[i] = Math.max(maxfreq[i], freq[i]);
            }
        }

        List<String> list = new ArrayList();
        for (String word : words1) {
            int[] freq = countFreq(word);
            boolean uni = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxfreq[i]) {
                    uni = false;
                    break;
                }
            }
               if (uni)
                    list.add(word);
        }
        return list;
    }

    private int[] countFreq(String word) {
        char[] chars = word.toCharArray();
        int[] freq = new int[26];
        for (char c : chars) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
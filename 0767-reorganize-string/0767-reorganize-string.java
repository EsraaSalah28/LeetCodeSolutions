class Solution {
          public static String reorganizeString(String s) {
            // Step 1: Frequency count
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // Step 2: Priority Queue (Max-Heap)
            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                    (a, b) -> b.getValue() - a.getValue()
            );
            pq.addAll(map.entrySet());
            StringBuilder sb = new StringBuilder();
            Map.Entry<Character, Integer> prev = null;
            while (!pq.isEmpty()) {
                Map.Entry<Character, Integer> current = pq.poll();
                sb.append(current.getKey());
                current.setValue(current.getValue() - 1);
                if (prev != null && prev.getValue() > 0) {
                    pq.add(prev);
                }
                prev = current;
            }
            if (sb.length() != s.length()) {
                return "";
            }
            return sb.toString();
        }

}
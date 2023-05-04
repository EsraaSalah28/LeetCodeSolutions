class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.offer(i);
            else dire.offer(i);
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            if (radiant.poll() < dire.poll()) radiant.offer(n++);
            else dire.offer(n++);
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
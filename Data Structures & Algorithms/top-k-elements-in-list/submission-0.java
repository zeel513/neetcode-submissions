class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        Queue<Integer> q = new PriorityQueue<>((a, b) -> (freq.get(b) - freq.get(a)));

        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for(int key: freq.keySet()) {
            q.add(key);
        }

        int[] result = new int[k];
        for(int i = 0; i < k && !q.isEmpty(); i++) {
            result[i] = q.poll();
        }

        return result;
    }
}

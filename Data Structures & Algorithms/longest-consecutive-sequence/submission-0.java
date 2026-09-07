class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }

        int result = 0;
        for(int n : set) {
            if(!set.contains(n - 1)) {
                int curr = 1;
                while(set.contains(n+1)) {
                    curr++;
                    n++;
                }
                result = Math.max(result, curr);
            }
        }

        return result;
    }
}

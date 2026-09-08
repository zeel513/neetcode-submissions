class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> index = new HashMap<>();
        int result = 0, start = 0, end = 0;

        while(end < s.length()) {
            if(index.getOrDefault(s.charAt(end), -1) != -1) {
                int temp = index.get(s.charAt(end));
                while(start <= temp) {
                    index.put(s.charAt(start), -1);
                    start++;
                }
            }
            index.put(s.charAt(end), end);
            result = Math.max(result, end-start+1);
            end++;
        }

        return result;
    }
}

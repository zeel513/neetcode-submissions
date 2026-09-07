class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s:strs) {
            String key = generateKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for(String key: map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    private String generateKey(String s) {
        StringBuilder sb = new StringBuilder();
        int[] f = new int[26];
        for(char c: s.toCharArray()) {
            f[c-'a']++;
        }
        for(int i = 0; i < 26; i++) {
            sb.append('a'+i);
            sb.append(f[i]);
        }

        return sb.toString();
    }
}

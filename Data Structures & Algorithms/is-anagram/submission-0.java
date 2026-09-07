class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] s1 = getFreq(s);
        int[] s2 = getFreq(t);

        for(int i = 0; i < 26; i++) {
            if(s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] getFreq(String s) {
        int[] result = new int[26];
        for(char c: s.toCharArray()) {
            result[c-'a']++;
        }
        return result;
    }
}

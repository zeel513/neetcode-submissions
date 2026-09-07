class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            StringBuilder len = new StringBuilder();
            while(str.charAt(i) != '#') {
                len.append(str.charAt(i));
                i++;
            }
            int l = Integer.parseInt(len.toString());
            StringBuilder s = new StringBuilder();
            i++;

            while(l > 0) {
                s.append(str.charAt(i));
                i++;
                l--;
            }

            result.add(s.toString());
        }

        return result;
    }
}

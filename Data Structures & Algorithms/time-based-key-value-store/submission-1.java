class TimeMap {

    class Pair {
        int timestamp;
        String value;

        public Pair(int t, String v) {
            timestamp = t;
            value = v;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        return find(map.get(key), timestamp);
    }

    // (1,4,7,10) , 6
    private String find(List<Pair> list, int time) {
        int left = 0, right = list.size() - 1;
        String result = "";
        while(left <= right) {
            int mid = (left + right) / 2;
            if(list.get(mid).timestamp <= time) {
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

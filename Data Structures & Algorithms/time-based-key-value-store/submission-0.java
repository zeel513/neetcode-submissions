class TimeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> m = map.getOrDefault(key, new TreeMap<>());
        m.put(timestamp, value);
        map.put(key, m);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> m = map.get(key);
        Map.Entry<Integer, String> e = m.floorEntry(timestamp);
        return e == null ? "" : e.getValue();
    }
}

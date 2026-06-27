class TimeMap {
    HashMap<String, List<String>> values;
    HashMap<String, List<Integer>> timestamps;

    public TimeMap() {
        values = new HashMap<>();
        timestamps = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(values.containsKey(key)) {
            values.get(key).add(value);
            timestamps.get(key).add(timestamp);
        } else {
            List<String> ls = new ArrayList<>();
            List<Integer> ts = new ArrayList<>();
            ls.add(value);
            ts.add(timestamp);
            values.put(key, ls);
            timestamps.put(key, ts);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!timestamps.containsKey(key)) return "";
        List<Integer> ts = null;
        ts = timestamps.get(key);
        int ans = -1, i=0, j=ts.size()-1;
        
        while(i <= j) {
            int mid = i + (j - i)/2;
            int n = timestamps.get(key).get(mid);
            if(n == timestamp) {
                return values.get(key).get(mid);
            } else if(n < timestamp) {
                ans = mid;
                i = mid + 1;
            } else j = mid - 1;
        }

        return ans == -1 ? "" : values.get(key).get(ans);
    }
}

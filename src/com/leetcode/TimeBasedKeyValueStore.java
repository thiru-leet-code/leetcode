package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

    Map<String, TreeMap<Integer, String>> map = null;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> m = map.getOrDefault(key, new TreeMap<>());
        m.put(timestamp, value);
        map.put(key, m);
    }

    public String get(String key, int timestamp) {
        TreeMap m =  map.get(key);
        if (m != null) {
            Object o = m.floorKey(timestamp);
            if (Objects.nonNull(o))return (String) m.get(o);
        }
        return "";
    }
}

package com.leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> top = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            TreeMap<Character, Integer> ini = new TreeMap<>();
            for (char c :cs) {
                int co = ini.getOrDefault(c, 0);
                co++;
                ini.put(c, co);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : ini.keySet()) {
                sb.append(c);
                sb.append(ini.get(c));
            }
            List<String> lt = top.getOrDefault(sb.toString(), new ArrayList<>());
            lt.add(s);
            top.put(sb.toString(), lt);
        }
        return  new ArrayList<>(top.values());

    }

    public static void main(String[] args) {
        //String[] n = {"eat","tea","tan","ate","nat","bat"};
        String[] n = {""};
        System.out.println(new GroupAnagrams().groupAnagrams(n));
    }
}

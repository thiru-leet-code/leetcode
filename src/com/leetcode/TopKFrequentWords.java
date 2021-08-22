package com.leetcode;

import java.util.*;

/*
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.



Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.


Constraints:

1 <= words.length <= 500
1 <= words[i] <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]


Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<Integer, TreeSet<String>> map = new TreeMap<>((a,b) -> b.compareTo(a));
        Map<String, Integer> smap = new HashMap<>();
        for (String s :words) {
            Integer i = smap.getOrDefault(s, 0);
            i++;
            smap.put(s,i);
        }
        smap.forEach( (ke,v) -> {
            TreeSet<String> strings = map.getOrDefault(v, new TreeSet<>());
            strings.add(ke);
            map.put(v,strings);
        });
        int i = 0;
        List<String> ans = new ArrayList<>();
       for ( Integer n : map.keySet()) {

           for (String s : map.get(n)) {
               if (i==k) {
                   return ans;
               }
               ans.add(s);
               i++;
           }

       }
       return  ans;
    }

    public static void main(String[] args) {
        String[] q = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        new TopKFrequentWords().topKFrequent(q,4);
    }
}

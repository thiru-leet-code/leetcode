package com.leetcode;

import java.util.*;

/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.



Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Example 3:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Burger King","Tapioca Express","Shogun"]
Output: ["KFC","Burger King","Tapioca Express","Shogun"]
Example 4:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger King","Tapioca Express","Shogun"]
Output: ["KFC","Burger King","Tapioca Express","Shogun"]
Example 5:

Input: list1 = ["KFC"], list2 = ["KFC"]
Output: ["KFC"]


Constraints:

1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i] and list2[i] consist of spaces ' ' and English letters.
All the stings of list1 are unique.
All the stings of list2 are unique.
 */
public class MinimumIndexSumofTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m1 = new HashMap<>();
        TreeMap<Integer, List<String>> m2 = new TreeMap<>();
        for (int i = 0; i < list1.length; i++) {
            m1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (m1.containsKey(list2[i])) {
                int y = i + m1.get(list2[i]);
                List<String> h =null;
                if (m2.containsKey(y)) {
                    h = m2.get(y);
                    h.add(list2[i]);
                }
                else {
                    h = new ArrayList<>();
                    h.add(list2[i]);
                    m2.put(y, h);
                }

            }
        }
        if (m2.size() ==0) return null;
        List<String> f = m2.firstEntry().getValue();
        return f.toArray(new String [f.size()]);
        }
    }


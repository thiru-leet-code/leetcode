package com.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DegreeOfArray {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1, 1};
        //int[] nums = {-1,-2};

        int ret = new DegreeOfArray()
                .findShortestSubArray(nums);

        String out = String.valueOf(ret);

        System.out.print(out);
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Holders> items =  new HashMap<>();
        Set<Integer> maxCountElements = new HashSet<>();
        Integer maxCOunt =1;
        for (int i=0; i< nums.length; i++) {
            if (items.containsKey( nums[i])) {
                Holders previous = items.get(nums[i]);
                items.put(nums[i], new Holders(previous.count+1, previous.first, i));
                if (maxCOunt < (previous.count+1)) {
                    maxCOunt = previous.count+1;
                    maxCountElements.clear();
                    maxCountElements.add(nums[i]);
                } else if (maxCOunt == previous.count+1) {
                    maxCountElements.add(nums[i]);
                }
            } else {
                items.put(nums[i], new Holders(1,i,i));
            }
        }
        Integer min = 0;
        for (Integer key: maxCountElements) {
            Holders ele = items.get(key);
            if (min >(ele.last-ele.first) || min ==0) {
                min = ele.last-ele.first;
            }
        }

        return min+1;
    }

    public class Holders {
        Integer count;
        Integer first;
        Integer last;
         public Holders(int count, int first, int last) {
          this.count = count;
          this.first = first;
          this.last = last;
         }
    }
}

package com.leetcode;

import java.util.*;

public class KEmptySlots {
	
	    public int kEmptySlots(int[] flowers, int k) {
	         TreeSet<Integer>  d = new TreeSet<>();
	        int day = 1;
	        for (int flower : flowers) {
	            d.add(flower);
	            Integer lower = d.lower(flower);
	            Integer higher = d.higher(flower);
	            if ((lower != null && flower-lower-1 == k) ||
	                    higher != null && higher-flower-1 == k) {
	                return day;
	            }
	            day++;
	        }
	        return -1;
	    }
	
	    

}

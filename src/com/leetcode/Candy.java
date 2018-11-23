package com.leetcode;
import java.util.*;
public class Candy {
	    public int candy(int[] ratings) {
	        TreeMap<Integer, List<Integer>> l = new TreeMap<>();
	        for (int i =0; i <= ratings.length-1; i++) {
	            List<Integer> s = l.getOrDefault(ratings[i], new ArrayList<>());
	            s.add(i);
	            l.put(ratings[i], s);
	        }
	        int total = 0;
	       // System.out.println(l);
	        Map<Integer,Integer> visit = new HashMap<>();
	        Map.Entry<Integer, List<Integer>> a = l.pollFirstEntry();
	        while (a != null) {
	            int u = 0;
	            for (Integer w: a.getValue()) {
	                u = 0;
	                if(visit.containsKey(w+1) || visit.containsKey(w-1)) {
	                    int y = 0;
	                    if (visit.containsKey(w-1)) {
	                        y = visit.get(w-1);
	                    }
	                    int x = 0;
	                    if (visit.containsKey(w+1)) {
	                        x = visit.get(w+1);
	                    }
	                    int z = Math.max(x,y);
	                    
	                    int az = w <= 0 ? Integer.MAX_VALUE: ratings[w-1];
	                    int az1 = w >= ratings.length-1 ? Integer.MAX_VALUE: ratings[w+1];
	                    int er = Math.min(az, az1);
	                   // System.out.println("az : " + az + " az1 : " + az1 + " er " + er + " x : " + x + " y: " + y);
	                    if (er == a.getKey()) {
	                      u++;  
	                    
	                    } 
	                    else {
	                        if (az < a.getKey() && az1 < a.getKey()) {
	                            u += (Math.max(x,y) +1);
	                        } else if (az == a.getKey())
	                            if (visit.containsKey(w+1)) u += (visit.get(w+1) +1);  else u += (Math.max(x,y) +1);
	                        else  if (visit.containsKey(w-1)) u += (visit.get(w-1) +1); else u += (Math.max(x,y) +1);
	                    } 
	                } else {
	                    u++;
	                }
	                total += u;
	                visit.put(w, u);
	               // System.out.println("Visit : " + visit + " total : " + total + " u : " + u);
	            }
	            
	            a = l.pollFirstEntry();
	        }
	        return total;
	        
	    }
	    
	    public int candyOptimal(int[] ratings) {
	        int sum = 0;
	        int[] left2right = new int[ratings.length];
	        int[] right2left = new int[ratings.length];
	        Arrays.fill(left2right, 1);
	        Arrays.fill(right2left, 1);
	        for (int i = 1; i < ratings.length; i++) {
	            if (ratings[i] > ratings[i - 1]) {
	                left2right[i] = left2right[i - 1] + 1;
	            }
	        }
	        for (int i = ratings.length - 2; i >= 0; i--) {
	            if (ratings[i] > ratings[i + 1]) {
	                right2left[i] = right2left[i + 1] + 1;
	            }
	        }
	        for (int i = 0; i < ratings.length; i++) {
	            sum += Math.max(left2right[i], right2left[i]);
	        }
	        return sum;
	    }
}

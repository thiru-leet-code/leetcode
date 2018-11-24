package com.leetcode;
import java.util.*;
public class EvaluateDivision {
	class Solution {
	    public double[] calcEquation(String[][] e, double[] values, String[][] q) {
	        Map<String, Map<String, Double>> ds = new HashMap<>();
	        for (int i = 0; i < e.length; i++) {
	            Map<String, Double> d = ds.getOrDefault(e[i][0], new HashMap<>());
	            d.put(e[i][1],values[i]);
	            Map<String, Double> d1 = ds.getOrDefault(e[i][1], new HashMap<>());
	            d1.put(e[i][0],(1/values[i]));
	            ds.put(e[i][0],d);
	            ds.put(e[i][1],d1);
	        }
	        double[] dc = new double[q.length];
	        for (int i = 0; i < q.length; i++) {
	            Map<String, Double> d = ds.get(q[i][0]);
	            if (d == null || !ds.containsKey(q[i][1])) {
	                dc[i] = -1;
	            } else {
	                dc[i] = find(ds, q[i][0] , q[i][1], new HashSet<>() );
	            }
	        }
	      return dc;  
	    }
	    
	    private double find(Map<String, Map<String, Double>> ds, String c, String f, Set<String> visited) {
	        Map<String, Double> d = ds.get(c);
	        if (d.containsKey(f)) {
	            return d.get(f);
	        }
	        double ss = -1;
	        for (String w : d.keySet()) {
	            if (!visited.contains(w)) {
	                visited.add(w);
	                ss = find(ds,w,f,visited);
	                if (ss != -1) {
	                    return ss*d.get(w);
	                }
	            }
	        }
	        return ss;
	    }
	}
}

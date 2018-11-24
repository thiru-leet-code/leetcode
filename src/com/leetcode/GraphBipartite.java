package com.leetcode;
import java.util.*;
public class GraphBipartite {
	
	
	    public boolean isBipartite(int[][] graph) {
	        boolean is = true;
	        Map<Integer, Integer> visited = new HashMap<>();
	        for (int i  =0; i <= graph.length-1; i++) {
	            if (!visited.keySet().contains(i)) {
	            	visited.put(i,0);
	            	is &=  DFS(graph, i, 0,visited);
	            }
	        }
	        return is;
	    }
	    
	    private boolean DFS(int[][] g, int i,  int pre, Map<Integer,Integer> v) {
        	System.out.println(v);
        	System.out.println("i : " + i);
	        int curr = 1-pre;
	        boolean is = true;
	        for (int j = 0; j <= g[i].length-1; j++) {  
	            Integer val = v.get(g[i][j]);
	            if (val == null) {
	                v.put(Integer.valueOf(g[i][j]), Integer.valueOf(curr));
	                is &= DFS(g, g[i][j], curr, v);
	            } else {
	            	System.out.println(v);
                    System.out.println("i :" + i + " j:" + g[i][j]);
                    System.out.println("val; " + val + " pre : " + pre);
	                if (val != curr) {
	                    System.out.println(v);
	                    System.out.println("i :" + i + " j:" + g[i][j]);
	                    System.out.println("val; " + val + " pre : " + pre);
	                    is =  false;
	                    break;
	                }
	            }
	        }
	        return is;
	    }
	    
	    public static void main(String[] d) {
	    	GraphBipartite g = new GraphBipartite();
	    	int[][] graph = {{}, {2,4,6}, {1,4,8,9}, {7,8}, {1,2,8,9}, {6,9}, {1,5,7,8,9}, {3,6,9}, {2,3,4,6,9}, {2,4,5,6,7,8}};
			System.out.println(g.isBipartite(graph ));
	    }
	

}

package com.leetcode;import java.util.*;
public class Rainwatersaving {

	    public int trap(int[] height) {
	            Stack<Integer> s = new Stack<>();
	            int area = 0;
	            for (int i = 0; i <= height.length -1; i++) {
	                while(s.size() > 0 && height[s.peek()] < height[i]) {
	                    int top = s.pop();
	                    if (s.size() > 0) {
	                        int next  = s.peek();
	                        area += (i - next -1) * (Math.min(height[i], height[next]) - height[top]);
	                    }
	                }
	                s.push(i);
	            }
	            return area;
	        }
	        
	    class BarDetail {
	        int val;
	        int index;
	        
	        BarDetail(int v, int i) {
	            this.val = v;
	            this.index = i;
	        }
	    }
	    
	    class AreaDetail {
	        int val;
	        int height;
	        
	        AreaDetail (int v, int h) {
	            val = v;
	            height = h;
	        }
	    }
	    
	    public static void main(String[] a) {
	    	Rainwatersaving r = new Rainwatersaving();
	    	int[] e = {0,1,0,2,1,0,1,3,2,1,2,1};
	    	System.out.println(r.trap(e));
	    }
	
}

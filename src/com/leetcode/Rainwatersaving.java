package com.leetcode;import java.util.*;


/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
{@link} https://leetcode.com/problems/trapping-rain-water/description/
 * 
 * 
 * @author thiru
 *
 */
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

package com.leetcode;
import java.util.*;
public class VerifyPreOrderBinaryTree {
	
	    public boolean isValidSerialization(String preorder) {
	        String[] c = preorder.split(",");
	        String pre = "";
	        int d = 0;
	        Stack<String> st = new Stack<>();
	        boolean right = false;
	        for (String cur : c) {
	            if (cur.equals("#")) {
	                if (st.size() > 0 && st.peek().equals("#")) {
	                     while (st.size() > 0 && st.peek().equals("#")) {
	                        st.pop();
	                        if (st.size() == 0) {
	                            return false;
	                        }st.pop();

	                    }
	                }               
	            }
	            st.push(cur);
	        }
	        System.out.println(st.size());
	        if (st.size() == 1 && st.peek().equals("#")) { //&& !st.peek().equals("#")
	            return true;
	        } else return false;
	    }
	    public boolean isValidSerializationOptimal(String preorder) {
	        int m=1;
	        String[] x=preorder.split(",");
	        for(int i=0;i<x.length;i++){
	          m--;
	          if(m<0) return false;
	          if(!x[i].equals("#")) m=m+2;
	        }
	        if(m==0){
	          return true;

	        }
	        else{
	            return false;
	        }

	        
	    }

}

package com.leetcode;
import java.util.*;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:

Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
Example 2:

Input: "1,#"
Output: false
Example 3:

Input: "9,#,#,1"
Output: false
 * @author thiru
 *
 */
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

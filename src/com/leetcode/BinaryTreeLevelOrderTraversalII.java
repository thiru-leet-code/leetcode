package com.leetcode;
import java.util.*;
public class BinaryTreeLevelOrderTraversalII {


     // Definition for a binary tree node.
      public class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root!=null) {
                TreeMap<Integer, List<Integer>> n= new TreeMap<>(Comparator.reverseOrder());
                fill(root,0,n);
                return new ArrayList<>(n.values());
            }
            return new ArrayList<>();
        }

        private void fill(TreeNode node, int index, TreeMap<Integer, List<Integer>> collect) {

            if (node.left != null) {
                fill(node.left, (index+1), collect);
            }
            if (node.right != null) {
                fill(node.right, (index+1), collect);
            }
            List<Integer> l = collect.get(index);
            if (l == null) {
                l = new ArrayList<>();
            }
            l.add(node.val);
            collect.put(index, l);
        }
    }
}

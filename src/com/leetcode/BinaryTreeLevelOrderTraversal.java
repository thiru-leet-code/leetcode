package com.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeLevelOrderTraversal {

      public class TreeNode {
          int val;
          TreeNode left;
         TreeNode right;
          TreeNode(int x) { val = x; }
      }

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root!=null) {
                Map<Integer, List<Integer>> n= new HashMap<>();
                fill(root,0,n);
                return new ArrayList<>(n.values());
            }
            return new ArrayList<>();
        }

        private void fill(TreeNode node, int index, Map<Integer, List<Integer>> collect) {
            List<Integer> l = collect.get(index);
            if (l == null) {
                l = new ArrayList<>();
            }
            l.add(node.val);
            collect.put(index, l);
            if (node.left != null) {
                fill(node.left, (index+1), collect);
            }
            if (node.right != null) {
                fill(node.right, (index+1), collect);
            }
        }

}

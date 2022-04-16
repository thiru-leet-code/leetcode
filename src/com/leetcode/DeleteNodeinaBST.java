package com.leetcode;

import com.leetcode.to.TreeNode;


/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Follow up: Can you solve it with time complexity O(height of tree)?



Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
 */
public class DeleteNodeinaBST {

    TreeNode replacing = null;
    TreeNode lh = null;

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root ==  null) return null;
        if (key == root.val) {
            TreeNode lowest = findLowest(root.right, root, false);
            TreeNode highest;
            if (lowest == null) {
                highest = findHighest(root.left, root, true);
                if (highest == null) {
                    return null;
                }else {
                    highest.right = root.right;
                    highest.left = root.left;
                    return highest;
                }

            } else {
                lowest.right = root.right;
                lowest.left = root.left;
                return lowest;
            }
        }
        find(root, key, root.left, true);
        find(root, key, root.right, false);
        return root;
    }

    private void find (TreeNode parent, int k, TreeNode current, boolean isleft) {
        if (current == null) return ;
        if (k < current.val ) {
             find(current, k, current.left, true);
        }
        if (k > current.val ) {
            find(current, k, current.right, false);
        }
        if (k == current.val) {
            TreeNode lowest = findLowest(current.right, current, false);
            TreeNode highest = null;
            if (lowest == null) {
                highest = findHighest(current.left, current, true);
                if (highest == null) {
                    if(isleft) parent.left = null;
                    else  parent.right = null;
                }else {
                    highest.right = current.right;
                    highest.left = current.left;
                    if(isleft) parent.left = highest;
                    else  parent.right = highest;
                }
            } else {
                lowest.right = current.right;
                lowest.left = current.left;
                if(isleft) parent.left = lowest;
                else  parent.right = lowest;
            }
        }
    }

    private TreeNode findLowest(TreeNode current, TreeNode parent, boolean isleft) {
    if (current == null) return  null;
        if (current.left == null) {
            if (isleft) parent.left = current.right;
            else parent.right = current.right;
            return current;
        }
        else return findLowest(current.left, current, true);
    }
    private TreeNode findHighest(TreeNode current, TreeNode parent, boolean isleft) {
        if (current == null) return  null;
        if (current.right == null) {
            if (isleft) parent.left = current.left;
            else parent.right = current.left;
            return current;
        }
        else return findHighest(current.right, current, false);
    }

    public static void main(String[] a ) {
        TreeNode root =  TreeNode.createTree("5,3,6,2,4,null,7");
        new DeleteNodeinaBST().deleteNode(root, 5);
        System.out.println(root);
    }
}

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    Node root;

    class Node {
        int val;
        Node left;
        Node right;
        Node(int i) {
            this.val = i;
        }
    }

    private Node add(Node add, int val) {
        if (add == null) {
            add = new Node(val);
        }
        if (val < add.val) {
            add.left = add(add.left, val);
        } else if (val > add.val) {
            add.right =  add(add.right, val);
        }
        return add;
    }

    private void add(int val) {
        root= add(root, val);
    }

    private int depth(Node n) {
        if (n == null) {
            return 0;
        }
        int leftDepth = depth(n.left);
        int rightDepth = depth(n.right);
        if (leftDepth > rightDepth) {
            return leftDepth+1;
        } else return rightDepth+1;
    }

    private static BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();
        bt.add(20);
        bt.add(10);
        bt.add(30);
        bt.add(5);
        bt.add(15);
        bt.add(25);
        bt.add(45);
        bt.add(2);
        bt.add(8);
        bt.add(12);
        bt.add(18);
        bt.add(22);
        bt.add(28);
        bt.add(32);
        bt.add(48);
        bt.add(14);

        return bt;
    }

    private void levelOrderTreeTraversal(Node node) {
        int depth = depth(node);
        List<Integer> traversal = new ArrayList<>();
        traversal.is
        for (int i = 1 ; i <= depth; i++) {
            printAtLevel(traversal,node, i, 1);
        }
        traversal.stream().forEach(e-> {
            System.out.print(e + "-");
        });
    }

    private void printAtLevel(List<Integer> traversal, Node node, int level, int currentLevel) {
       if(node!=null) {
           if (level == currentLevel) {
               traversal.add(node.val);
           }
           if (level > currentLevel) {
               printAtLevel(traversal, node.left, level, currentLevel + 1);
               printAtLevel(traversal, node.right, level, currentLevel + 1);
           }
       }
    }

    private void delete(int val) {
        delete(root, val);
    }

    private int findLeast(Node node){
        if (node.left==null) {
            return node.val;
        } else return findLeast(node.left);
    }

    private Node delete(Node delete, int val) {
        if (delete == null) {
            return null;
        }
        if (delete.val == val) {
            if (delete.left == null && delete.right == null) {
                return  null;
            }  else if (delete.left == null) {
                return delete.right;
            } else if (delete.right == null) {
                return delete.left;
            } else {
                delete.val = findLeast(delete.right);
                delete.right = delete(delete.right, delete.val);
                return delete;
            }
        }
        else if (val < delete.val) {
            delete.left = delete(delete.left, val);
            return delete;
        } else {
            delete.right = delete(delete.right, val);
            return delete;
        }
    }

    private boolean isExists(int val) {
        return isExists(root,val);
    }

    private boolean isExists(Node node, int val) {
        if (node == null) {
            return false;
        }
        if(node.val == val) {
            return true;
        } else if (val<node.val) {
           return isExists(node.left, val);
        } else {
            return isExists(node.right, val);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = createBinaryTree();
        System.out.println("Depth : " + bt.depth(bt.root));
        bt.levelOrderTreeTraversal(bt.root);
        System.out.println();
        bt.delete(10);
        bt.levelOrderTreeTraversal(bt.root);
    }
}

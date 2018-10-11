package com.dictionary;

import java.util.HashMap;
import java.util.Map;

public class AddSearchWordTree {



    class TreeNode {
        char c;
        int minlength;
        Map<Character, TreeNode> childNode = new HashMap<>();;

        TreeNode(char c, int i){
            this.c =c;
            this.minlength = i;
        }

        void updateMin(int i) {
            if (minlength > i) {
                minlength = i;
            }
        }

       }

    Map<Character,TreeNode> words = null;

    /** Initialize your data structure here. */
    public AddSearchWordTree() {
        words = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word != null && word.length() > 0) {
            char[] c = word.toCharArray();
             TreeNode nodes = null;
            for (int i =0; i <= word.length()-1; i++) {
                if (i==0 ) {
                    if (words.get(c[i])==null) {
                        nodes = new TreeNode(c[i], word.length());
                        words.put(c[i], nodes);
                    } else {
                        nodes = words.get(c[i]);
                        nodes.updateMin(word.length());
                    }
                }
                else {
                    TreeNode n = nodes.childNode.get(c[i]);
                    if (n == null) {
                        n = new TreeNode(c[i], word.length()-i);
                        nodes.childNode.put(c[i], n);
                    } else {
                        n.updateMin(word.length()-i);
                    }
                    nodes = n;

                }
            }
        }

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return interSearch(word.toCharArray(), words, 0);
    }

    private boolean interSearch(char[] word, Map<Character,TreeNode> n, int i) {
        if (word.length == i) {
            if (n.size() > 0) {
                return false;
            } return true;
        }
        TreeNode x = n.get(word[i]);
        if (x!=null) {
            if (i==word.length-1 && x.minlength ==(word.length-i)) {
                return true;
            }
            return interSearch(word,x.childNode, i+1);
        } else if (word[i] == '.') {
            for (TreeNode f: n.values()){
                if (i==word.length-1 && f.minlength == (word.length -i)) {
                    return true;
                }
                if(interSearch(word,f.childNode, i+1)) return true;
            }
        }

        return false;

    }

    public static void main(String[] a) {
        AddSearchWordTree d = new AddSearchWordTree();
        d.addWord("bad");
        d.addWord("dad");
        d.addWord("mad");
        d.addWord("m");
        d.addWord("bads");
        System.out.println(d.search("pad"));
        System.out.println(d.search("bad"));
        System.out.println(d.search("b.d"));
        System.out.println(d.search("."));
        System.out.println(d.search("m"));
        System.out.println(d.search("bad"));


    }

}

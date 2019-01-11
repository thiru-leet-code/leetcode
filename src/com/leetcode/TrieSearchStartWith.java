package com.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

 * 
 * 
 * 
 * @author thiru
 *
 */
public class TrieSearchStartWith {

        class Node {
            char c;
            boolean leaf;
            Map<Character, Node> child = new HashMap<>();
            Node(char c) {
                this.c=c;
            }
            Node(){

            }
        }

        Node root = null;

        /** Initialize your data structure here. */
        public TrieSearchStartWith() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Map<Character, Node> a = root.child;
            char[] c = word.toCharArray();
            for (int i = 0; i <= word.length()-1; i++) {
                if (!a.containsKey(c[i])) {
                    a.put(c[i], new Node(c[i]));
                }
                if(i == word.length()-1) {
                    a.get(c[i]).leaf = true;
                }
                a = a.get(c[i]).child;
            }

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Map<Character, Node> a = root.child;
            char[] c = word.toCharArray();
            int i = 0;
            for (; i <= word.length()-1; i++) {
                if (!a.containsKey(c[i])) {
                    break;
                }
                if (i < word.length()-1) {
                    a = a.get(c[i]).child;
                }

            }
            if(i == word.length() && a.get(c[i-1]).leaf) {
                return true;
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Map<Character, Node> a = root.child;
            char[] c = prefix.toCharArray();
            int i = 0;
            for (; i <= prefix.length()-1; i++) {
                if (!a.containsKey(c[i])) {
                    break;
                }
                a = a.get(c[i]).child;
            }
            if(i == prefix.length()) {
                return true;
            }
            return false;
        }

}

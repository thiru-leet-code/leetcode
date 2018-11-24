package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddSearchWord {

        List<List<Character>> words = null;

        /** Initialize your data structure here. */
        public AddSearchWord() {
            words = new ArrayList<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word != null && word.length() > 0) {
                List<Character> cWord = new ArrayList<>();
                char[] chars = word.toCharArray();
                for(char c : chars){
                    cWord.add(c);
                }
                words.add(cWord);
            }

        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            boolean found = false;
            for(List<Character> lc : words) {
                //System.out.println("lc.size() - " + lc.size() + " word.length() - " + word.length());
                if (lc.size() == word.length()) {
                    int i = 0;
                    for (char c : lc) {
                        char[] d = word.toCharArray();
                        //  System.out.println(d[i] + ":" + c);
                        if (d[i] != '.' && c != d[i]) {
                            break;
                        }
                        i++;
                    }
                    // System.out.println("i:"+i+" word.lenght-"+word.length());
                    if (i == word.length()) {
                        found = true;
                    }
                }
                if (found) {
                    break;
                }
            }
            return found;
        }

}

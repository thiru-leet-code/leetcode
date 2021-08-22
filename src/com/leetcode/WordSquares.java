package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unique strings words, return all the word squares you can build from words. The same word from words can be used multiple times. You can return the answer in any order.

A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.


Example 1:

Input: words = ["area","lead","wall","lady","ball"]
Output: [["ball","area","lead","lady"],["wall","area","lead","lady"]]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input: words = ["abat","baba","atan","atal"]
Output: [["baba","abat","baba","atal"],["baba","abat","baba","atan"]]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).


Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 5
All words[i] have the same length.
words[i] consists of only lowercase English letters.
All words[i] are unique.

 */
public class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        if (words.length == 1 && words[0].length() == 1) {
            List<String> k = new ArrayList<>();
            k.add(words[0]);
            return Arrays.asList(k);
        }
        List<List<String>> x = new ArrayList<>();
        for (String s : words) {
            List<List<String>> y = new ArrayList<>();
            if (check(s, 0, 0, new char[s.length()][s.length()], words,new ArrayList<>(), y)) {
                for (List<String> z : y) {
                    if (z.size() == s.length()) x.add(z);
                }
            }
        }
        return x;
    }

    private boolean check(String curstr, int row, int col, char[][] mapping, String[] words, List<String> y, List<List<String>> x) {
        if (row ==curstr.length() && col == curstr.length()) return true;
        if (row ==0 && col == 0) {
            for (int i =0; i < curstr.length(); i ++) {
                mapping[row][i] = curstr.charAt(i);
                mapping[row+i][col] = curstr.charAt(i);
            }
            y.add(curstr);
            return check(curstr, row +1, col+1, mapping, words, y, x);
        } else {

            String d = "";
            for (int i = 0; i < col; i ++) {
                d += mapping[row][i];
            }
            List<String> startswith  = new ArrayList<>();
            for (String s : words) {
                if (s.startsWith(d) ) {
                    for (int i =0; i < s.length(); i ++) {
                        mapping[row][i] = s.charAt(i);
                        mapping[i][col] = s.charAt(i);
                    }
                    y.add(s);
                    if (check(curstr, row +1, col+1, mapping, words, y, x) ) {
                        List<String> k = new ArrayList<>();
                        k.addAll(y);
                        x.add(k);
                        y.remove(s);
                    }
                }
            }
        }
        return x.size() > 0;
    }

    public static void main(String[] args) {
        String[] t = {"abat","baba","atan","atal"};
        System.out.println(new WordSquares().wordSquares(t));
    }
}

package com.leetcode;

/**
 * Did work... thought of doing a full/long palindrome and iterate and find
 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ShortestPalindrome {

  public String shortPalindrome(String s) {
   List<Character> sa = new LinkedList<>();
      IntStream.range(0,s.length()).forEach( i-> {
          sa.add(s.charAt(i));
      });
   int frontIndex = 0;
   int backIndex = s.length() -1;
   while(backIndex !=0){
   if (s.charAt(frontIndex) == s.charAt(backIndex)) {
   frontIndex++;backIndex--;
   } else {
   sa.add(frontIndex, s.charAt(backIndex));
   backIndex--;
   }
   }
   StringBuilder returnString = new StringBuilder();
   for (Character cg : sa) {
       returnString.append(cg);
   }
   return returnString.toString();
  }

  public static void main(String[] args) {
      ShortestPalindrome sp = new ShortestPalindrome();
      System.out.println("aacecaaa : " + sp.shortPalindrome("aacecaaa"));
      System.out.println("abcd : " + sp.shortPalindrome("abcd"));
      System.out.println("aacecaaa : " + sp.shortPalindrome("bacecaba"));
      System.out.println("abfeba : " + sp.shortPalindrome("abfeba"));

  }
}

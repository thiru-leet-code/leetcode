package com.leetcode;
import java.util.*;
/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
	a) it                      --> it    (no abbreviation)
	
	     1
	b) d|o|g                   --> d1g
	
	              1    1  1
	     1---5----0----5--8
	c) i|nternationalizatio|n  --> i18n
	
	              1
	     1---5----0
	d) l|ocalizatio|n          --> l10n
	Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's 
	abbreviation is unique if no other word from the dictionary has the same abbreviation.
	Example: 
	Given dictionary = [ "deer", "door", "cake", "card" ]
	
	isUnique("dear") -> false
	isUnique("cart") -> true
	isUnique("cane") -> false
	isUnique("make") -> true
	
	Understand the problem:
	The question is a little bit tricky. 
	There are only 2 conditions we return true for isUnique("word")
	1. The abbr does not appear in the dict. 
	2. The abbr is in the dict && the word appears one and only once in the dict. 
	
 * @author thiru
 *
 */
public class UniqueWordAbbreviation {
	
Map<String, String> dic = new HashMap<>();
    
    public void ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            String sd = null;
            if (s==null || s.length() < 2) sd = (s);
            else sd = (s.substring(0,1) + (s.length()-2) + s.substring(s.length()-1));
            String i = dic.get(sd);
            if (i == null) {
                dic.put(sd,s);
            } else {
                if (!i.equals(s)) {
                     dic.put(sd,"");
                }
            }            
        }
        System.out.println(dic);
        
    }
    
    public boolean isUnique(String s) {
         String sd = null;
        if (s==null || s.length() < 2) sd = (s);
        else sd = (s.substring(0,1) + (s.length()-2) + s.substring(s.length()-1));
        
        String i = dic.get(sd);
        if (i == null ) return true;
        if (i.equals(s)) return true;
        else return false;
    }

}

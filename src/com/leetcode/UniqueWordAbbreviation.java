package com.leetcode;
import java.util.*;
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

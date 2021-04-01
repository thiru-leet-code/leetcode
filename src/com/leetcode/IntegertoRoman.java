package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class IntegertoRoman {

    public static void main(String[] args) {
        System.out.println("III : " + intToRoman(44));
        System.out.println("D : " + intToRoman(1994));
        System.out.println("XL : " + intToRoman(500));
    }

    static Map<Character, Character> fr = new HashMap();
    static Map<Character, Character> ls = new HashMap();
    public static String intToRoman(int num) {
        LinkedList<Character> thousands = new LinkedList();
        int q = num/1000;
        if (q>0) push('M', num/1000, thousands);
        LinkedList<Character> hunds = new LinkedList();
        int r = num%1000;
        q = r/500;
        if (q>0) push('D', r/500, hunds);
        r = num%500;
        q = r/100;
        if (q>0) push('C', r/100, hunds);
        LinkedList<Character> tens = new LinkedList();
        r = num%100;
        q = r/50;
        if (q>0) push('L', r/50, tens);
        r = num%50;
        q = r/10;
        if (q>0) push('X', r/10, tens);
        LinkedList<Character> once = new LinkedList();
        r = num%10;
        q = r/5;
        if (q>0) push('V', r/5, once);
        r = num%5;
        push('I', r, once);
        StringBuffer sb = new StringBuffer();
        while (thousands.size() > 0) {
            sb.append(thousands.pollLast());
        }
        while (hunds.size() > 0) {
            sb.append(hunds.pollLast());
        }
        while (tens.size() > 0) {
            sb.append(tens.pollLast());
        }
        while (once.size() > 0) {
            sb.append(once.pollLast());
        }
        return sb.toString();

    }

    private static void push(char c, int count, LinkedList<Character> fi ) {
        for (int i = count; i > 0; i--) {
            fi.addFirst(c);
        }
        if (count == 4 && (c == 'I' || c== 'X' || c == 'C')) {
            char first = ' ';
            for ( int i = count ; i>=0 && fi.size() > 0 ; i--) {
                /*if (first == ' ') first = fi.pollFirst();
                else fi.pollFirst();*/
                if (i > 0 || (fi.peek() == 'V' || fi.peek() == 'L' || fi.peek() == 'D'))
                    first = fi.pollFirst();
            }
            fi.push(c);
            if (first != c) fi.push(ls.get(c));
            else fi.push(fr.get(c));
        }
    }

    static {
        fr.put('I', 'V');
        fr.put('X', 'L');
        fr.put('C', 'D');
        ls.put('I', 'X');
        ls.put('X', 'C');
        ls.put('C', 'M');
    }
}

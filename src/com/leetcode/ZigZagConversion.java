package com.leetcode;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        char[][] dd = new char[numRows][c.length]; // have to refine this
        for (int i = 0, col=0; i< c.length; col++) {
            for(int j=0; j< numRows && i< c.length; j++, i++) {
                dd[j][col] = c[i];
            }
            for(int j=numRows-2; j>0 && i< c.length; j--, i++) {
                col++;
                dd[j][col]= c[i];
            }

        }
        StringBuffer sf = new StringBuffer();
        for(int i=0; i< numRows; i++) {
            for(int j=0; j< c.length; j++) {
                if (dd[i][j] != '\u0000') sf.append(dd[i][j]);
            }
        }
        return sf.toString();

    }

    public static void main(String[] args) {
        System.out.println("PINALSIGYAHRPI".equals(new ZigZagConversion().convert("PAYPALISHIRING", 4)));
        System.out.println("PAHNAPLSIIGYIR".equals(new ZigZagConversion().convert("PAYPALISHIRING", 3)));
    }
}

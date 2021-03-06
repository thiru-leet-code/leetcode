package com.leetcode;

import java.util.*;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 * @author thiru
 *
 */

public class SudokuValidate {

	    public boolean isValidSudoku(char[][] b) {
	        Set<Character> row = new HashSet<>();
	        Set<Character> column = new HashSet<>();
	        Map<String, Set<Character>> sub = new HashMap<>();
	        for (int i = 0; i <= b.length-1; i++) {
	            for (int j = 0; j <=b.length-1; j++) {
	                if (b[i][j]!='.' && !row.add(b[i][j])) {
	                    System.out.println(i + "-" +j);
	                    return false;
	                } 
	               if (b[j][i]!='.' && !column.add(b[j][i])) {
	                    return false;
	                }
	                String key = findSub(i,j);
	                if (b[i][j]!='.' && !sub.keySet().contains(key)) {
	                    Set<Character> d = new HashSet<>();
	                    sub.put(key, d);
	                }
	               if (b[i][j]!='.' && !sub.get(key).add(b[i][j])) {
	                    return false;
	                }
	            }
	            row.clear();
	            column.clear();
	        }
	        return true;
	    }
	    
	    private String findSub(int i, int j) {
	        if (i<3 && j<3) {
	            return "s1";
	        } 
	        if (i< 3 && j < 6) {
	            return "s2";
	        } if (i<3 && j<9) {
	            return "s3";
	        } if (i<6 && j < 3) {
	            return "s4";
	        } if (i<6 && j<6) {
	            return "s5";
	        } if (i <6 && j<9) {
	            return "s6";
	        } if (i< 9 && j<3) {
	            return "s7";
	        }if (i< 9 && j<6) {
	            return "s8";
	        }if (i< 9 && j<9) {
	            return "s9";
	        }
	        return "s9";
	    }
	
}

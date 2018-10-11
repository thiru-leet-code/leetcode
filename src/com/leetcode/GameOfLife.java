package com.dictionary;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

        public void gameOfLife(int[][] board) {
            List<Integer[]> off = new ArrayList<>();
            List<Integer[]> on = new ArrayList<>();
            for (int i =0; i <= board.length-1; i++) {
                for (int j =0; j <=board[i].length-1; j++) {
                    int livesAround = numberOfLivingCell(i, j, board);
                    if (board[i][j] == 1) {
                        if ((livesAround < 2 || livesAround > 3)) {
                            Integer[] as = new Integer[2];
                            as[0] = i;
                            as[1] = j;
                            off.add(as);
                        }
                    }
                    else if (board[i][j] == 0) {
                        System.out.println("i:" + i + " j:" + j + " Live:" + livesAround);
                        if (livesAround == 3){
                            Integer[] as = new Integer[2];
                            as[0] = i;
                            as[1] = j;
                            on.add(as);
                        }

                    }
                }
            }
            for (Integer[] d : off) {
                board[d[0]][d[1]]= 0;
            }
            for (Integer[] d : on) {
                board[d[0]][d[1]]= 1;
            }
        }

        private int numberOfLivingCell(int i, int j, int[][] b) {
            int living = 0;
            if (i-1 >=0) {
                if (j-1 >=0 ) {
                    if (b[i-1][j-1] == 1) {
                        living++;
                    }
                }
                if (b[i-1][j] == 1) {
                    living++;
                }
                if (j+1 < b[i].length) {
                    if (b[i-1][j+1] == 1) {
                        living++;
                    }

                }
            }
            if (j-1 >=0 ) {
                if (b[i][j-1] == 1) {
                    living++;
                }
            }
            if (j+1 < b[0].length) {
                if (b[i][j+1] == 1) {
                    living++;
                }
            }
            if (i+1 < b.length) {
                if (j-1 >=0) {
                    if (b[i+1][j-1] == 1) {
                        living++;
                    }
                }
                if(b[i+1][j] == 1) {
                    living++;
                }
                if (j+1 < b[0].length) {
                    if (b[i+1][j+1] == 1) {
                        living++;
                    }
                }
            }
            return living;
        }

}

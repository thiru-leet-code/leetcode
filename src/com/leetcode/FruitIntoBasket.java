package com.leetcode;

public class FruitIntoBasket {


        public int totalFruiton2(int[] tree) {
            int maxFruit = 0;
            for (int i = 0; i<= tree.length-1 ; i++) {
                int second = -1;
                int count = 0;
                for (int j = i; j<= tree.length-1; j++) {
                    if (tree[i] != tree[j] && second == -1) {
                        second = tree[j];
                        count++;
                    } else if (tree[i] == tree[j] || second == tree[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (maxFruit < count) {
                    maxFruit=count;
                }
            }
            return maxFruit;
        }

        public int totalFruit(int[] tree) {
            int maxFruit = 0;
            int second = -1;
            int first = 0;
            int fcount = 0;
            int scount = 0;
            if (tree.length < 2) {
                return tree.length;
            }
            first = tree[0];

            fcount = 1;
            int contin = 1;
            for (int i = 1; i<= tree.length-1 ; i++) {
                //  System.out.println("tree[i] " + tree[i]);
                Integer f = 1;
                f.hashCode();
                if (tree[i-1] == tree[i]) {
                    contin++;
                } else if (first == tree[i] || second == tree[i] || second == -1) {
                    contin =1;
                }
                if (first != tree[i] && second == -1) {
                    second = tree[i];
                    scount++;
                }
                else if (first == tree[i]) {
                    fcount++;
                } else if (second == tree[i]) {
                    scount++;
                } else {
                    // System.out.println("i : " + i + " Count : " + fcount + " Scount " + scount + " Contin : " + contin);
                    second = tree[i];
                    first = tree[i-1];
                    if (maxFruit < (fcount+scount)) {
                        maxFruit=(fcount+scount);
                    }
                    fcount = contin;
                    scount=1;
                    contin = 1;
                }
            }
            if (maxFruit < (fcount+scount)) {
                maxFruit=(fcount+scount);
            }
            return maxFruit;
        }


}

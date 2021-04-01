package com.leetcode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SocksMatching {



        // Complete the sockMerchant function below.
        static int sockMerchant(int n, int[] ar) {
            Map<Integer, Integer> sm = new HashMap();
            for (int a : ar) {
                int i = sm.getOrDefault(a, 0);i++;
                sm.put(a, i);
            }
            int c = 0;
            for (int v : sm.values()) {
                c+= v/2;
            }
            return c;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            int[] i={1,1,3,1,2,1,3,3,3,3};
           SocksMatching.sockMerchant(10, i);
        }


}

package com.leetcode;

public class CompareVersionNumbers {

        public int compareVersion(String version1, String version2) {
            String[] v1s = version1.split("\\.");
            String[] v2s = version2.split("\\.");
            for (int i =0; i < v1s.length || i< v2s.length; i++) {
                int f = i < v1s.length ? Integer.valueOf(v1s[i]) : 0;
                int s = i < v2s.length ? Integer.valueOf(v2s[i]) : 0;
                if (f >s) return 1;
                else if (s>f) return -1;

            }
            return 0;

        }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("1.0.1", "1"));
        System.out.println(new CompareVersionNumbers().compareVersion("1.0.1", "1.0.2"));
    }

}

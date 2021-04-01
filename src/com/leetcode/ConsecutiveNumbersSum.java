package com.leetcode;

/***
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 *
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 *
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 *
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * Note: 1 <= N <= 10 ^ 9.
 */
public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum1(int N) {
        int si = 1;
        int n=1;
        int ctr = 0;
        for (int i = si; i<=N; i++) {
            ctr +=i;
            if (ctr == N) {
                n++;
                i=si;
                si++;
                ctr=0;
            } else if (ctr > N) {
                i=si;
                si++;
                ctr=0;
            }

        }
        return n;
    }

    public int consecutiveNumbersSum(int N) {
        int result = 1;
        int sum = 0;
        int i = 2;

        while (sum < N){
            sum += i - 1;
            if ((N - sum > 0) && (N - sum) % i == 0) result++;
            i++;
        }

        return result;
    }



    public static void main(String[] args) {
        System.out.println("2:" + new ConsecutiveNumbersSum().consecutiveNumbersSum(53965645));
        System.out.println("3:" + new ConsecutiveNumbersSum().consecutiveNumbersSum(9));
        System.out.println("4:" + new ConsecutiveNumbersSum().consecutiveNumbersSum(15));
    }
}

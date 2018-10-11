package com.dictionary;

import java.util.*;

public class SplitArrayToConsequence {

    //[1,2,3,3,4,4,5,5]
    //[1,2,3,3,4,5]
    //[3,4,4,5,6,7,8,9,10,11]
        public boolean isPossible(int[] nums)  {

            List<Stack<Integer>> cons = new ArrayList<>();
            for (int i =0; i<= nums.length-1; i++) {
                int canbeadded = -1;
                if (cons.size() ==0) {
                    Stack<Integer> ds = new Stack<>();
                    ds.push(nums[i]);
                    cons.add(ds);
                } else {
                    boolean added = false;
                    int d = 0;
                    for (Stack<Integer> con : cons) {
                        int top = con.peek();
                        if (con.size() <3) {

                            if (nums[i] == top+1){
                                con.push(nums[i]);
                                added=true;
                                if (i+1 == nums.length) {
                                    if (con.size() < 3) {
                                        return false;
                                    }
                                }
                                break;
                            }
                        }
                        if (nums[i] == top+1){
                            canbeadded = d;
                        }
                        if (i+1 == nums.length) {
                            if (con.size() < 3) {
                                return false;
                            }
                        }
                        d++;
                    }
                    if(!added) {

                        if (canbeadded != -1) {
                            Stack<Integer> con = cons.get(canbeadded);
                            con.push(nums[i]);
                        }
                        else {
                            Stack<Integer> ds = new Stack<>();
                            ds.push(nums[i]);
                            cons.add(ds);
                        }

                    }
                }

            }

            if (cons.size() == 0 || cons.get(0).size() <3) {
                return false;
            }

            return true;
        }

    public boolean isPossibleOptimal(int[] nums) {
        Counter count = new Counter();
        Counter tails = new Counter();
        for (int x: nums) count.add(x, 1);

        for (int x: nums) {
            if (count.get(x) == 0) {
                continue;
            } else if (tails.get(x) > 0) {
                tails.add(x, -1);
                tails.add(x+1, 1);
            } else if (count.get(x+1) > 0 && count.get(x+2) > 0) {
                count.add(x+1, -1);
                count.add(x+2, -1);
                tails.add(x+3, 1);
            } else {
                return false;
            }
            count.add(x, -1);
        }
        return true;
    }

    public boolean isPossibleSuggested(int[] nums) {
        Integer prev = null;
        int prevCount = 0;
        Queue<Integer> starts = new LinkedList<>();
        int anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            int t = nums[i];
            if (i == nums.length - 1 || nums[i+1] != t) {
                int count = i - anchor + 1;
                if (prev != null && t - prev != 1) {
                    while (prevCount-- > 0)
                        if (prev < starts.poll() + 2) return false;
                    prev = null;
                }

                if (prev == null || t - prev == 1) {
                    while (prevCount > count) {
                        prevCount--;
                        if (t-1 < starts.poll() + 2)
                            return false;
                    }
                    while (prevCount++ < count)
                        starts.add(t);
                }
                prev = t;
                prevCount = count;
                anchor = i+1;
            }
        }

        while (prevCount-- > 0)
            if (nums[nums.length - 1] < starts.poll() + 2)
                return false;
        return true;
    }

        public static void main(String[] args) {
            SplitArrayToConsequence i = new SplitArrayToConsequence();
            int[] o = {1,2,3,4,4,5};
            System.out.println(i.isPossible(o));
        }


    class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }


}

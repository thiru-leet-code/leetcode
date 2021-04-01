package com.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MaxEvents {

        public int maxEvents(int[][] e) {
            TreeMap<Integer, PriorityQueue<Integer>> ou = new TreeMap();
            Integer fsd = null;
            Integer lsd = null;
            for (int i = 0; i <= e.length-1; i++) {
                PriorityQueue<Integer> tt = ou.getOrDefault(e[i][0], new PriorityQueue<Integer>());
                tt.add(e[i][1]);
                ou.put(e[i][0], tt);
                if (fsd == null || fsd > e[i][0]) {
                    fsd = e[i][0];
                }
                if (lsd == null || lsd < e[i][1]) {
                    lsd = e[i][1];
                }
            }
            int[] ar = new int[e.length+1];
            String s = ou.toString();
            LinkedList<Event> ll = new LinkedList();
            for (int i =0; i<= lsd-1; i++) {
                Event es = new Event();
                es.sd = -1;
                es.ed = -1;
                ll.add(es);

            }
            int cd = 0;
            for (int k: ou.keySet()) {
                PriorityQueue<Integer> pq = ou.get(k);

                for (int d : pq) {
                    cd++;
                    if (ll.get(k-1).sd ==-1) {
                        Event e1 = new Event();
                        e1.sd =k;
                        e1.ed = d;
                        ll.remove(k-1);
                        ll.add(k-1,e1);
                    } else {
                        boolean found = false;
                        for(int i = k-1; i< d ; i++) {
                            Event e2 = ll.get(i);
                            if ((i+1 >= k && i<= d) && e2.sd ==-1) {
                                Event e1 = new Event();
                                e1.sd=k;
                                e1.ed=d;
                                ll.remove(i);
                                ll.add(i, e1);
                                found = true;
                                break;
                            }
                        }
                        if (!found) for(int i = k-1; i< d ; i++) {
                            Event e2 = ll.get(i);
                            if ((i+1 > e2.sd && i+1< e2.ed) || e2.sd ==-1) {
                                Event e1 = new Event();
                                e1.sd=k;
                                e1.ed=d;
                                ll.add(i, e1);
                                break;
                            }
                        }
                    }
                }

            }
            s = ll.toString();
            int csd = 0;
            for (int y=0; cd > 0 && y <= ll.size()-1; y++) {
                Event fg = ll.get(y);
                if (fg.sd !=-1){
                    csd++;
                    cd--;
                }
            }
            s = ll.toString();
            return csd;
        }

        public class Event {
            public int sd;
            public int ed;

            @Override
            public String toString() {
                return String.format(sd + ":" + ed);
            }
        }


    public static void main(String[] args) {
        //int[][] d = {{25,26},{19,19},{9,13},{16,17},{17,18},{20,21},{22,25},{11,12},{19,23},{7,9},{1,1},{21,23},{14,14},{4,7},{16,16},{24,28},{16,18},{4,5},{18,20},{16,16},{25,26}};
        //int [][] d = {{27,27},{8,10},{9,11},{20,21},{25,29},{17,20},{12,12},{12,12},{10,14},{7,7},{6,10},{7,7},{4,8},{30,31},{23,25},{4,6},{17,17},{13,14},{6,9},{13,14}};
        //int[][] d = {{1,100000}};
        //int[][] d = {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
        int[][] d = {{13,14},{29,32},{10,13},{10,11},{9,11},{21,25},{18,22},{30,30},{27,29},{13,17},{30,32},{17,17},{4,4},{20,23},{22,25},{9,11},{15,16},{24,26},{7,8},{15,19},{11,15},{5,8},{8,9},{23,26},{2,5},{27,28},{28,32}};
        System.out.println("27:" + new MaxEvents().maxEvents(d));

    }
}

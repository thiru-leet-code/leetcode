package com.leetcode;

import java.util.*;

public class SpecialBinaryString {
        public String makeLargestSpecial(String s) {
            Stack<Character> ts = new Stack<>();
            Map<Integer, Holder> map = new HashMap<>();
            int trcker = 0;
            char direction = ' ';
            List<Character> prefix = new ArrayList<>();
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    if (direction == 'D') {
                        prefix.addAll(ts);
                        ts.clear();
                    }
                    ts.push(c);
                    direction = 'U';
                } else {
                    if (direction == 'U') {
                        trcker++;
                    }
                    if (ts.size() > 0 ) {
                        char p1 = ts.pop();
                        Holder holder = map.getOrDefault(trcker, new Holder());
                        holder.pq.addFirst(p1);
                        holder.pq.addLast('0');
                        holder.tracker = trcker;
                        map.put(trcker, holder);
                    } else ts.push(c);
                    direction = 'D';
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char p : prefix) {
                sb.append(p);
            }
            TreeSet<Holder> treeSet = new TreeSet(map.values());
            for (Holder h : treeSet.descendingSet()) {
                Object[] ca =  h.pq.toArray();
                for (Object c : ca) {
                    sb.append(c);
                }
            }
            for (char p: ts) {
                sb.append(p);
            }
            return sb.toString();
        }

        public class Holder implements Comparable {
            public LinkedList<Character> pq = new LinkedList<>();
            public int tracker;

            @Override
            public int compareTo(Object o) {
                if (pq.size() == ((Holder) o).pq.size())  return tracker-((Holder) o).tracker;
                return pq.size()- ((Holder) o).pq.size();
            }
        }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(' '));
        System.out.println(Integer.valueOf('a'));
        System.out.println(new SpecialBinaryString().makeLargestSpecial("101010"));
    }

}

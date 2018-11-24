package com.leetcode;

import java.util.PriorityQueue;

public class ExamRoom {

    PriorityQueue<Intervals> seats = new PriorityQueue<>((a, b) -> a.interval != b.interval? b.interval-a.interval : a.x-b.x);
    int N;

    class Intervals {
        int x, y, interval;

        Intervals(int x, int y) {
            this.x =x;
            this.y = y;
            if (this.x == -1) {
                interval = y;
            } else if (y== N) {
                interval = N -1 -x;
            } else
                interval = Math.abs(x-y) / 2;
        }
    }



    ExamRoom(int N) {
        this.N = N;
        this.seats.add(new Intervals(-1, N));
    }


    public int seat() {
        int currentSeat;
        Intervals top = this.seats.poll();
        if (top.x == -1) {
            currentSeat = 0;
        }
        else if(top.y ==  this.N) {
            currentSeat =  this.N-1;
        } else
            currentSeat = (top.x +top.y) /2;
        this.seats.offer(new Intervals(top.x, currentSeat));
        this.seats.offer(new Intervals(currentSeat, top.y));

        return currentSeat;
    }

    public void leave(int outSeat) {
        Intervals first = null, last = null;
        System.out.println("outSeat -> " + outSeat);
        for(Intervals seat : seats) {
            //  System.out.println("seat.x ->" + seat.x + "  seat.y ->" + seat.y);
            if (seat.x == outSeat) {
                last = seat;
            } else if (seat.y == outSeat) {
                first = seat;
            }
            if (first != null && last != null) {
                break;
            }
        }
        if (first!= null && last !=null) {
            this.seats.remove(first);
            this.seats.remove(last);
            System.out.println("First ->" + first.x);
            System.out.println("Last ->" + last.y);
            this.seats.offer(new Intervals(first.x,last.y));
        }
    }

    public static void main(String[] args) {

    }
}

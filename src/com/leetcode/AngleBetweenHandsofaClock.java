package com.leetcode;
/*
Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

 */
public class AngleBetweenHandsofaClock {

    public double angleClock(int hour, int minutes) {
        int perminMin = 6;
        double perminHrs = .5;
        int perhr = 30;

        double hrsMOved = ((hour %12) * perhr) + (minutes * perminHrs);
        int minMoved = minutes * perminMin;

        double between = Math.abs(hrsMOved - minMoved);
        return Math.min(between, 360-between);

    }

}

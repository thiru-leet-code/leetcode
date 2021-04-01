package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/***
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 * Example 4:
 *
 * Input: asteroids = [-2,-1,1,2]
 * Output: [-2,-1,1,2]
 * Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 *
 *
 * Constraints:
 *
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */
public class AsteroidCollision {

    public int[] asteroidCollisionOld(int[] asteroids) {
        List<Integer> fi = new ArrayList<>();
        Stack<Integer> right = new Stack<>();
        Stack<Integer> left = new Stack<>();
        for(int i : asteroids) {
          /*  if (right.size()==0 && left.size() ==0) {
                if(i >0) {
                    right.push(i);
                } else {
                    left.push(i);
                }
            }
            else*/ if (i < 0) {
                if (right.size() == 0) {
                    fi.add(i);
                    //left.push(i);
                    continue;
                }
                while (right.size() > 0) {
                    int l = right.peek();
                    if (l > Math.abs(i)) {
                        break;
                    } else if (l == Math.abs(i)){
                        right.pop();
                        break;
                    }
                    if ( right.size() == 0) fi.add(i);
                }
            } else {
                if (right.size() == 0) {
                    fi.add(i);
                    continue;
                }
                while (left.size() > 0) {
                    int l = Math.abs(left.peek());
                    if (l > Math.abs(i)) {
                        break;
                    } else if (l == Math.abs(i)){
                        left.pop();
                        break;
                    }
                    if ( left.size() == 0) fi.add(i);
                }
            }
        }

        return fi.stream().mapToInt(i->i).toArray();
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> space = new Stack<>();
        for (int st : asteroids) {
            if (space.size() == 0) {
                space.push(st);
            } else {
                int pe = space.peek();
                if (pe <0 && st < 0) space.push(st);
                else if (pe>0 && st>0) space.push(st);
                else {
                    if (pe <0 && st >0) {
                        space.push(st); continue;
                    }
                    while (pe >0 && st <0 && Math.abs(st) >= pe) {
                        if (Math.abs(pe) <= Math.abs(st)) space.pop();
                        if (space.size() > 0 && Math.abs(pe) != Math.abs(st)) pe = space.peek();
                        else {
                            if (Math.abs(pe) != Math.abs(st))space.push(st);
                            break;
                        }
                    } if (space.size() > 0 && pe <0 ) space.push(st);
                }
            }
        }
        ///return space.stream().mapToInt(i->i).toArray();
        int[] o = new int[space.size()];
        int c = 0;
        for ( Object i : space.toArray()) {
            o[c] = (int)i;
            c++;
        }
        return o;
    }

    public static void main(String[] args) {
        //int[] d = {5,10,-5};
       // int[] d = {-2,-1,1,2};
        int[] d = {-2,-2,1,-1};
        //int[] d = {-2,-2,1,-2};
        //int[] d = {10,2,-5};
        Arrays.stream(new AsteroidCollision().asteroidCollision(d)).forEach( value -> System.out.println( value));
        //System.out.println(new AsteroidCollision().asteroidCollision(d));
    }

}

package com.leetcode;

public class GasStation {
	
	public void trst() {
		Integer i =100;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(-i));
		int d = i & -i;
		System.out.print("D >> " + d);
	}
	
	public static void main(String[] s) {
		GasStation g = new GasStation()
				;
		g.trst();
	}

    public int canCompleteCircuit_mine(int[] gas, int[] cost) {
        int nodeCnt = gas.length;
        int index = 0;
        int current = -1;
        int tank = 0;
        int i = 0;
        int remaining = 0;
        while (index<=nodeCnt-1 ) {
            System.out.println("index : " + index);
            int g = tank+gas[index];
            int c = cost[index];
            remaining += (g - c);
            if (g<c) {
                tank =0;
                if (current != -1 && i>=nodeCnt) {
                    current = -1;
                    break;
                }
                current = -1;
                index++;
            } else  {
                if (index+1 == current) {
                    return current;
                }
                tank = g-c;
                if (current == -1) {
                    current =index;
                }
                index++;
            }
            if (index== nodeCnt ) {
                if (current == -1) {
                    return current;
                }
                if (current!=0) {
                    index = index !=1 ? 0 : 1;
                }
                if (remaining < 0) {
                    return -1;
                }

            }
            i++;
        }
        return current;
    }


    // Other effective solution

    public int canCompleteCircuit_site(int[] gas, int[] cost) {
        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int remaining = gas[i] - cost[i];

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
                //otherwise, reset start index to be current
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            return start;
        }else{
            return -1;
        }
    }
}

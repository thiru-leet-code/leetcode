package com.leetcode;

public class MedianTwoSortedArray {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int i =0;
	        int j =0;
	        boolean even = false;
	        int end = ((nums1.length+nums2.length)/2) +1;
	                int[] finalA = new int[end];
	        if ((nums1.length+nums2.length) % 2 == 0) {
	            even = true;
	        } 
	        System.out.println("end : " + end);
	        for (int h =0; h <= end-1 ; h++) {
	            if  (i <nums1.length && j < nums2.length) {
	                if  (nums1[i] < nums2[j]) {
	                    finalA[h] = nums1[i];
	                    i++;
	                } else if (nums1[i] > nums2[j]) {
	                    finalA[h] = nums2[j];
	                    j++;
	                } else {
	                    finalA[h] = nums1[i];
	                    i++;
	                    h++;
	                    if (h<end) {
	                                            finalA[h] = nums2[j];
	                    }
	                    j++;
	                }
	            } else if (i <nums1.length) {
	                 finalA[h] = nums1[i];
	                    i++;
	            } else if  (j < nums2.length) {
	                finalA[h] = nums2[j];
	                    j++;
	            }
	        }
	        for (int a: finalA)
	        System.out.print(a);
	        if  (even) {
	            return Double.valueOf(((double)finalA[end-1] + (double)finalA[end-2])/2);
	        }
	        return Double.valueOf(finalA[end-1]);
	        
	    }
	
}

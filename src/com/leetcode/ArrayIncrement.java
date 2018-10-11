package com.dictionary;

import java.util.stream.IntStream;

public class ArrayIncrement {

private Integer[] increment(Integer[] input, int index) {
  if (input[index] != 9) {
    input[index] = input[index] + 1;
    return input;
  } else if (index ==0 && input[index] == 9) {
    Integer[] newArray = new Integer[input.length + 1];
    newArray[0] = 1;
    newArray[newArray.length-1] = 0;
    return newArray;
  } else if (input[index] == 9) {
    Integer[] returned = increment(input, index -1);
    returned[index] = 0;
    return returned;
  }
  return input;
}

private Integer[] startIncrement(Integer[] input) {
  if (input.length == 0) {
   Integer[] newArray = new Integer[1];
   newArray[0] = 1;
   return newArray;
  } else {
    return increment(input, (input.length)-1);
  }
}

public static void main(String[] a) {
ArrayIncrement arrayIncrement = new ArrayIncrement();
Integer[] newArray = {9,9,9};
Integer[] returned = arrayIncrement.startIncrement(newArray);
IntStream.range(0, returned.length).forEach(i -> {
  System.out.print(returned[i] + " ");
});
}
}

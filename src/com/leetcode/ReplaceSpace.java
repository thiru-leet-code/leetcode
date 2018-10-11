package com.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceSpace{

  public String replaceSpace(String words){
    if (words != null) {
      int spaceIndex = words.indexOf(" ");
      List<Integer> spaceIndexes = new ArrayList<>();
      int j = spaceIndex;
        spaceIndexes.add(spaceIndex);
      while (j >= 0){
        j = words.substring(spaceIndex+1).indexOf(" ");
        if (j>=0) {
            spaceIndex = spaceIndex+j+1;
            spaceIndexes.add(spaceIndex+j+1);
        }
      }
      char[] wordsArray = words.toCharArray();
      char[] finalWord = new char[wordsArray.length + (spaceIndexes.size() * 2)];

      int finalArrCnt = 0;
      for (int i = 0 ; i < words.length(); i++) {
        if (words.charAt(i) == ' ') {
          finalWord[finalArrCnt++] = '%';
          finalWord[finalArrCnt++] = '2';
          finalWord[finalArrCnt++] = '0';
        } else {
          finalWord[finalArrCnt] = words.charAt(i);
          finalArrCnt++;
        }
      }

      return Arrays.toString(finalWord);
    }
    return null;
  }

  public static void main(String[] args) {
    ReplaceSpace rs= new ReplaceSpace();
    System.out.println(rs.replaceSpace("i love songs"));
    System.out.println(rs.replaceSpace("thiru"));
   System.out.println(rs.replaceSpace("thirumalai "));
   System.out.println(rs.replaceSpace(" "));
   System.out.println(rs.replaceSpace(" Nata rajan "));
    System.out.println(rs.replaceSpace("   "));
  }
}

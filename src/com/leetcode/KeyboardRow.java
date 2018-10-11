package com.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class KeyboardRow{


List<Character> firstRow = Arrays.asList('q','w','e','r','t','y','u','i','o','p');
List<Character> secondRow = Arrays.asList('a','s','d','f','g','h','j','k','l');
List<Character> thirdRow = Arrays.asList('z','x','c','v','b','n','m');

  public String[] findWords(String[] words) {
  List<String> turnStrings = new ArrayList<>();
    for(String word : words) {
      if (firstRow.contains(word.toLowerCase().charAt(0)) && isAvailable(word, firstRow)) {
        turnStrings.add(word);
      } else if (secondRow.contains(word.toLowerCase().charAt(0)) && isAvailable(word, secondRow)) {
        turnStrings.add(word);
      } else if(thirdRow.contains(word.toLowerCase().charAt(0)) && isAvailable(word, thirdRow)) {
        turnStrings.add(word);
      }
    }
    String [] o = new String[turnStrings.size()];
    return turnStrings.toArray(o);
  }

  private boolean isAvailable(String word, List<Character> row) {
  int contains = 0;
    for(int i = 0; i < word.length(); i++) {
      if(row.contains(word.toLowerCase().charAt(i))) contains++;
      else break;
    }
    return contains==word.length();

  }

  public static void main(String[] args) {
      KeyboardRow key = new KeyboardRow();
      String[] d = {"Hello", "Alaska", "Dad", "Peace"};
      key.findWords(d);
    }
}

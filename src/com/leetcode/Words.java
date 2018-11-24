package com.leetcode;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Words {

    List<String> words = Arrays.asList("thiru", "ganeshs", "deivanayagam");
    Logger log = Logger.getLogger(Words.class.getName());

    List<Character> chars = Arrays.asList('a','e','h','g','n','s','f','r');

    public void findBig() {
        final Map<String, String> longWord = new HashMap<>() ;
        words.forEach(word -> {
            List<Character> cloneChar = new ArrayList<>(chars);
            char[] wordsArray = word.toCharArray();
            log.info("Words : " + word);
            Set<String> usedCharIndex = new HashSet<>();
            IntStream.range(0,wordsArray.length).forEach( index -> {
                if (cloneChar.contains(wordsArray[index])) {
                    usedCharIndex.add(String.valueOf(wordsArray[index] + index));
                    int i = cloneChar.indexOf(wordsArray[index]);
                    cloneChar.remove(i);
                } if (index == (wordsArray.length -1)) {
                    log.info("usedCharIndex.size() ........! for : " + usedCharIndex.size() );
                    if (usedCharIndex.size() == wordsArray.length) {
                        log.info("Inside........! for : ");
                        if (longWord.get("long") == null
                                || longWord.get("long").length() <= word.length()) {
                            log.info("This is long word : " + word);
                            longWord.put("long",word);
                        }
                    }
                    usedCharIndex.clear();
                }
            });

        });
        System.out.println("Long Word  keyssssssss : " + longWord.keySet());
        longWord.values().stream().forEach( word -> {
            System.out.println("Long Word : " + word);
        });
    }

    public static void main (String[] agrs) {
        Words words = new Words();
        words.findBig();
    }

}

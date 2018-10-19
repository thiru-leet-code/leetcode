package com.card;

import java.util.Arrays;

public class DeckGroup {
    String[] cards = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    Suits suit;

    DeckGroup(Suits suit) {
        this.suit = suit;
    }
}
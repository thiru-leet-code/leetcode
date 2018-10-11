package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Deck {
    List<DeckGroup> deck = Arrays.asList(new DeckGroup(Suits.Spade),new DeckGroup(Suits.Hearts),new DeckGroup(Suits.Clubs),new DeckGroup(Suits.Diamond));
    Random random = new Random();
    Card[][] finalDeck = new Card[4][13];
    int cardid,suitid, swapCardid, swapSuitId;
    Card swap;

    public void shuffleDeck() {
        IntStream.range(0,13).forEach((nbr -> {
            finalDeck[0][nbr] = new Card(deck.get(0).suit ,deck.get(0).cards[nbr]);
            finalDeck[1][nbr] = new Card(deck.get(1).suit ,deck.get(1).cards[nbr]);
            finalDeck[2][nbr] = new Card(deck.get(2).suit ,deck.get(2).cards[nbr]);
            finalDeck[3][nbr] = new Card(deck.get(3).suit ,deck.get(3).cards[nbr]);
        }));
        IntStream.range(0,4).forEach( suit -> {
            IntStream.range(0,13).forEach( card -> {
                Card cards = finalDeck[suit][card];
                System.out.println(cards.suits+ "-" + cards.card);
            });
        });

        System.out.print("********************************************");
        IntStream.range(0,(520)).forEach(nbr -> {
            cardid = random.nextInt(13);
            suitid = random.nextInt(4);
            swap = finalDeck[suitid][cardid];
            swapCardid = random.nextInt(13);
            swapSuitId = random.nextInt(4);
            finalDeck[suitid][cardid] = finalDeck[swapSuitId][swapCardid];
            finalDeck[swapSuitId][swapCardid] = swap;

        });

        IntStream.range(0,4).forEach( suit -> {
            IntStream.range(0,13).forEach( card -> {
                Card cards = finalDeck[suit][card];
                System.out.println(cards.suits+ "-" + cards.card);
            });
        });
    }

}

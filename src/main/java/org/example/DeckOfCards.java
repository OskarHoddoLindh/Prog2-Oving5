package org.example;
import java.util.Random;

public class DeckOfCards {
    private final char[] suits = {'S', 'H', 'D', 'C'};
    private final String[] value = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

    public String[] dealHand(int n) {
        String[] hand = new String[n];
        Random random = new Random();

        for (int i = 0; i<n; i++) {
            char suit = suits[random.nextInt(suits.length)];
            String rank = value[random.nextInt(value.length)];
            hand[i] = suit + rank;
        }
        return hand;
    }


}




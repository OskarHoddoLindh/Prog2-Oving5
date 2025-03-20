package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {

    @Test
    public void testDealHand() {
        DeckOfCards deck = new DeckOfCards();
        int handSize = 5;
        String[] hand = deck.dealHand(handSize);

        // Sjekk at hånden har riktig antall kort
        assertEquals(handSize, hand.length);

        // Sjekk at hvert kort i hånden er gyldig
        for (String card : hand) {
            assertTrue(card.matches("[SHDC][1-9]|[SHDC]1[0-3]|[SHDC]A")); // regexmønster tilpassa til 11,12,13 som konge osv
        }
    }

    @Test
    public void testDealHandWithDifferentSizes() {
        DeckOfCards deck = new DeckOfCards();

        for (int i = 1; i <= 52; i++) {
            String[] hand = deck.dealHand(i);
            assertEquals(i, hand.length);
        }
    }
}
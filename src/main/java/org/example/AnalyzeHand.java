package org.example;

import java.util.HashMap;
import java.util.Map;

public class AnalyzeHand {

    public Map<Character, Integer> analyzeHand(String[] hand) {
        Map<Character, Integer> suitCount = new HashMap<>();

        for (String card : hand) {
            char suit = card.charAt(0);
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }

        return suitCount;
    }
}

/*
metoden tar en hånd som input og returnerer et Map som viser antall kort av hver farge
 */
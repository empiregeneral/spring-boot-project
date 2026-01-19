package cn.pintia.zjo.problem1111.entity;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardUtils {
    private final static int cardsInHand = 5;

    public static Card[] toCards(String players) {
        List<Card> cardList = new ArrayList<>();
        Scanner scanner = new Scanner(new ByteArrayInputStream(players.getBytes()));
        while(scanner.hasNext()) {
            cardList.add(Card.valueOf(scanner.next()));
        }
        scanner.close();
        Collections.sort(cardList);
        return cardList.toArray(new Card[cardsInHand]);
    }
}

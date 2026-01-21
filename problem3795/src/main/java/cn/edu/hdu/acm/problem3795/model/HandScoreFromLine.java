package cn.edu.hdu.acm.problem3795.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: canzuo
 * @Date: 2026/1/20 19:00
 * @Version: V1.0
 * @Description: Component
 */
@Component
public class HandScoreFromLine implements IHandScoreFromLine {
    private String input;
    private int[] ranks = new int[PokerHand.HAND_SIZE];
    private int[] suits = new int[PokerHand.HAND_SIZE];

    public int HandScoreFromLine(String input) {
        this.input = input;
        String[] cards = input.split(" ");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < PokerHand.HAND_SIZE; i++) {
            String card = cards[i];
            assert card.length() == 2;
            ranks[i] = PokerHand.R.indexOf(card.charAt(0));
            suits[i] = PokerHand.S.indexOf(card.charAt(1));
            assert ranks[i] >= 0 && suits[i] >= 0;
            assert set.add(card);
        }
        Arrays.sort(ranks);
        return hand(input);
    }
    @Override
    public int hand(String input) {
        int hand = 0;
        for (int i = 0; i < PokerHand.HAND_SIZE; i++) {
            hand = PokerHand.setCard(hand, i, ranks[i]);
        }

        boolean flush = true;
        for (int i = 1; i < PokerHand.HAND_SIZE; i++) {
            flush = flush & (suits[i] == suits[i-1]);
        }

        if (flush) {
            hand = PokerHand.setFlush(hand);
        }
        return hand;
    }
}

package cn.pintia.zjo.problem1111.model;

import cn.pintia.zjo.problem1111.entity.Card;
import cn.pintia.zjo.problem1111.entity.CardUtils;
import cn.pintia.zjo.problem1111.enumeration.PokerHandType;
import org.springframework.stereotype.Component;

@Component
public class PokerHand {
    private Card[] cards;


    public PokerHandType pokerHandType(String playerHands) {
        cards = CardUtils.toCards(playerHands);
        int maxScores = 0;
        PokerHandType type = PokerHandType.HIGH_CARD;
        for (PokerHandType handType : PokerHandType.values()) {
            if (handType.isValid(cards)) {
                if (handType.getScores() > maxScores) {
                    maxScores = handType.getScores();
                    type = handType.getHandType();
                }
            }
        }
        return type;
    }

}

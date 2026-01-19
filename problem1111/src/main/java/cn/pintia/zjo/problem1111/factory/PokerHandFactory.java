package cn.pintia.zjo.problem1111.factory;

import cn.pintia.zjo.problem1111.entity.Card;
import cn.pintia.zjo.problem1111.enumeration.Judgement;
import cn.pintia.zjo.problem1111.enumeration.PokerHandJudgement;
import cn.pintia.zjo.problem1111.enumeration.PokerHandType;

public class PokerHandFactory {
    public static Judgement showHandJudgement(Card[] blackHand, Card[] whiteHand, PokerHandType pokerHandType) {
        Judgement result = null;
        switch (pokerHandType) {
            case STRAIGHT_FLUSH:
                result = PokerHandJudgement.STRAIGHT_FLUSH.judgement(blackHand, whiteHand);
                break;
            case FOUR_Of_A_KIND:
                result = PokerHandJudgement.FOUR_Of_A_KIND.judgement(blackHand, whiteHand);
                break;
            case FULL_HOUSE:
                result = PokerHandJudgement.FULL_HOUSE.judgement(blackHand, whiteHand);
                break;
            case FLUSH:
                result = PokerHandJudgement.FLUSH.judgement(blackHand, whiteHand);
                break;
            case STRAIGHT:
                result = PokerHandJudgement.STRAIGHT.judgement(blackHand, whiteHand);
                break;
            case THREE_OF_A_KIND:
                result = PokerHandJudgement.THREE_OF_A_KIND.judgement(blackHand, whiteHand);
                break;
            case TWO_PAIRS:
                result = PokerHandJudgement.TWO_PAIRS.judgement(blackHand, whiteHand);
                break;
            case PAIR:
                result = PokerHandJudgement.PAIR.judgement(blackHand, whiteHand);
                break;
            case HIGH_CARD:
                result = PokerHandJudgement.HIGH_CARD.judgement(blackHand, whiteHand);
                break;
        }

        return result;
    }
}

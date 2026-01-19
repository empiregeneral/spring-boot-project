package cn.pintia.zjo.problem1111.enumeration;

import cn.pintia.zjo.problem1111.entity.Card;
import cn.pintia.zjo.problem1111.factory.ShowHandEvaluator;

public enum PokerHandJudgement {
    STRAIGHT_FLUSH(PokerHandType.STRAIGHT_FLUSH) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.straightFlush(blackHand, whiteHand);
        }
    },

    FOUR_Of_A_KIND(PokerHandType.FOUR_Of_A_KIND) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.fourOfAKind(blackHand, whiteHand);
        }
    },

    FULL_HOUSE(PokerHandType.FULL_HOUSE) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.fullHouse(blackHand, whiteHand);
        }
    },

    FLUSH(PokerHandType.FLUSH) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.flush(blackHand, whiteHand);
        }
    },

    STRAIGHT(PokerHandType.STRAIGHT) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.straight(blackHand, whiteHand);
        }
    },

    THREE_OF_A_KIND(PokerHandType.THREE_OF_A_KIND) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.threeOfKind(blackHand, whiteHand);
        }
    },

    TWO_PAIRS(PokerHandType.TWO_PAIRS) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.twoPair(blackHand, whiteHand);
        }
    },

    PAIR(PokerHandType.PAIR) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.pair(blackHand, whiteHand);
        }
    },

    HIGH_CARD(PokerHandType.HIGH_CARD) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.highCard(blackHand, whiteHand);
        }
    };

    private PokerHandType handType;


    PokerHandJudgement(PokerHandType handType) {
        this.handType = handType;
    }

    public abstract Judgement judgement(Card[] blackHand, Card[] whiteHand);

}

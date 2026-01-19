package cn.pintia.zjo.problem1111.enumeration;

import cn.pintia.zjo.problem1111.entity.Card;
import cn.pintia.zjo.problem1111.factory.PokerHandTypeEvaluator;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum PokerHandType implements IPokerHandType{
    /**
     * 牌面最大的牌
     */
    HIGH_CARD("HIGH_CARD", 0) {
        @Override
        public PokerHandType getHandType() {
            return PokerHandType.HIGH_CARD;
        }

        @Override
        public boolean isValid(Card[] hand) {
            return PokerHandTypeEvaluator.hasHighestCard(hand);
        }
    },

    /**
     * 对子
     */
    PAIR("PAIR",1) {
        @Override
        public PokerHandType getHandType() {
            return PokerHandType.PAIR;
        }

        @Override
        public boolean isValid(Card[] hand) {
            return PokerHandTypeEvaluator.hasOnePair(hand);
        }
    },

    /**
     * 2个对子,按照最大的一对对子的大小进行排序，如果相同，比较较小的一对对子，如果还是相同，请比较剩下的牌面
     */
    TWO_PAIRS("TWO PAIRS", 2) {
        @Override
        public PokerHandType getHandType() {
            return PokerHandType.TWO_PAIRS;
        }

        @Override
        public boolean isValid(Card[] hand) {
            return PokerHandTypeEvaluator.hasTwoPairs(hand);
        }
    },

    /**
     * 三条，3个同样牌，按照3张牌的牌面大小排序
     */
    THREE_OF_A_KIND("THREE_OF_A_KIND", 3) {
        @Override
        public PokerHandType getHandType() {
            return PokerHandType.THREE_OF_A_KIND;
        }

        @Override
        public boolean isValid(Card[] hand) {
            return PokerHandTypeEvaluator.hasThreeOfAKind(hand);
        }
    },

    /**
     * 顺子,五张依次递增的牌,按照最大牌的大小排序
     */
    STRAIGHT("STRAIGHT", 4) {
        @Override
        public PokerHandType getHandType() {
            return PokerHandType.STRAIGHT;
        }

        @Override
        public boolean isValid(Card[] hand) {
            return PokerHandTypeEvaluator.hasStraight(hand);
        }
    },

    /**
     * 同花，5个花色一样的牌, 按照最大牌面大小排序。
     */
    FLUSH("FLUSH", 5) {
        @Override
        public PokerHandType getHandType() {
            return PokerHandType.FLUSH;
        }

        @Override
        public boolean isValid(Card[] hand) {
            return PokerHandTypeEvaluator.hasFlush(hand);
        }
    },

    /**
     * 葫芦，3个同样的牌加上1个对子，按照3张相同的牌面大小排序。
     */
    FULL_HOUSE("FULL_HOUSE", 6) {
        @Override
        public PokerHandType getHandType() {
            return PokerHandType.FULL_HOUSE;
        }

        @Override
        public boolean isValid(Card[] hand) {
            return PokerHandTypeEvaluator.hasFullHouse(hand);
        }
    },

    /**
     * 四条,4个同样的牌加一个牌，按照4张牌面大小排序。
     */
    FOUR_Of_A_KIND("FOUR_OF_A_KINE", 7) {
        @Override
        public PokerHandType getHandType() {
            return PokerHandType.FOUR_Of_A_KIND;
        }

        @Override
        public boolean isValid(Card[] hand) {
            return PokerHandTypeEvaluator.hasFourOfAKind(hand);
        }
    },
    /**
     * 同花顺，按照最大的牌面大小排序。
     */
    STRAIGHT_FLUSH("STRAIGHT_FLUSH", 8) {
        @Override
        public PokerHandType getHandType() {
            return PokerHandType.STRAIGHT_FLUSH;
        }

        @Override
        public boolean isValid(Card[] hand) {
            return PokerHandTypeEvaluator.hasStraightFlush(hand);
        }
    };

    private String description;
    private int scores;

    PokerHandType(String description, int scores) {
        this.description = description;
        this.scores = scores;
    }

    public String getDescription() {
        return description;
    }

    public int getScores() {
        return scores;
    }

    /**
     * Verify if a handType is present in a given hand.
     *
     * @param hand Set of cards.
     * @return {@code true} if the hand type is present in the hand, {@code false}
     * otherwise.
     */
    public abstract boolean isValid(Card[] hand);

    private static final Map<String, PokerHandType> stringToEnum = Stream.of(values()).collect(toMap(Object::toString, e -> e));

    public static Optional<PokerHandType> fromString(String handType) {
        return Optional.ofNullable(stringToEnum.get(handType));
    }
}

interface IPokerHandType {
    PokerHandType getHandType();
}




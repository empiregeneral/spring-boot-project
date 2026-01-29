package cn.edu.hdu.acm.problem1629.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PokerHand {
    public static final int HAND_SIZE = 5;
    public static final int C1 = HAND_SIZE - 1;
    public static final int C2 = HAND_SIZE - 2;
    public static final int C3 = HAND_SIZE - 3;
    public static final int C4 = HAND_SIZE - 4;
    public static final int C5 = HAND_SIZE - 5;

    public static final String R = "23456789TJQKA";
    public static final String S = "CDHS";

    public static final int ACE = R.indexOf('A');
    public static final int TWO = R.indexOf('2');
    public static final int THREE = R.indexOf('3');
    public static final int FOUR = R.indexOf('4');
    public static final int FIVE = R.indexOf('5');
    public static final int KING = R.indexOf('K');
    public static final int QUEUE = R.indexOf('Q');
    public static final int JACK = R.indexOf('J');
    public static final int TEN = R.indexOf('T');

    public static final int CARD_BITS = 4;
    public static final int CARD_MASK = (1 << CARD_BITS) - 1;
    public static final int FLUSH_SHIFT = HAND_SIZE * CARD_BITS;
    public static final int FLUSH_MASK = 1 << FLUSH_SHIFT;

    public static int getCard(int hand, int i) {
        assert i >= 0 && i < HAND_SIZE;
        return (hand >> (CARD_BITS * i)) & CARD_MASK;
    }

    public static int setCard(int hand, int i, int rank) {
        assert i >= 0 && i < HAND_SIZE;
        int shift = CARD_BITS * i;
        return (hand & ~(CARD_MASK << shift)) | (rank << shift);
    }

    public static int swapCard(int hand, int i, int j) {
        return setCard(setCard(hand, i, getCard(hand, j)), j, getCard(hand, i));
    }

    public static int moveCard(int hand, int to, int from) {
        assert to >= from;
        for (int i = from; i < to; i++) {
            hand = swapCard(hand, i, i + 1);
        }
        return hand;
    }

    public static boolean isFlush(int hand) {
        return (hand >> FLUSH_SHIFT) != 0;
    }

    public static int setFlush(int hand) {
        return hand | FLUSH_MASK;
    }

    private static int clearFlush(int hand) {
        return hand & ~FLUSH_MASK;
    }

    public static final int ACE_ROLLED_STRAIGHT =
            setCard(setCard(setCard(setCard(setCard(0,
                                                    C1, ACE),
                                            C2, FIVE),
                                    C3, FOUR),
                            C4, THREE),
                    C5, TWO);

    enum Ranking {
        HIGH_CARD {
            @Override
            int map(int hand) {
                return hand;
            }
        },
        ONE_PAIR {
            @Override
            int map(int hand) {
                for (int i = HAND_SIZE; --i > 0; ) {
                    if (getCard(hand, i) == getCard(hand, i - 1)) {
                        return moveCard(moveCard(hand, C1, i), C2, i - 1);
                    }
                }
                return -1;
            }
        },
        TWO_PAIRS {
            @Override
            int map(int hand) {
                hand = ONE_PAIR.map(hand);
                if (hand < 0) {
                    return -1;
                }
                for (int i = HAND_SIZE - 2; --i > 0; ) {
                    if (getCard(hand, i) == getCard(hand, i - 1)) {
                        return moveCard(moveCard(hand, C3, i), C4, i - 1);
                    }
                }
                return -1;
            }
        },
        THREE_OF_A_KIND {
            @Override
            int map(int hand) {
                for (int i = HAND_SIZE; --i > 1; ) {
                    if (getCard(hand, i) == getCard(hand, i - 1) && getCard(hand, i) == getCard(hand, i - 2)) {
                        return moveCard(moveCard(moveCard(hand, C1, i), C2, i - 1), C3, i - 2);
                    }
                }
                return -1;
            }
        },

        STRAIGHT {
            @Override
            int map(int hand) {
                if (hand == ACE_ROLLED_STRAIGHT) {
                    return moveCard(hand, C1, C2);
                }
                for (int i = HAND_SIZE; --i > 0; ) {
                    if (getCard(hand, i) != getCard(hand, i - 1) + 1) {
                        return -1;
                    }
                }
                return hand;
            }
        },
        FLUSH {
            @Override
            int map(int hand) {
                return isFlush(hand) ? hand : -1;
            }
        },
        FULL_HOUSE {
            @Override
            int map(int hand) {
                hand = THREE_OF_A_KIND.map(hand);
                return hand < 0 ? -1 : getCard(hand, C4) == getCard(hand, C5) ? hand : -1;
            }
        },
        FOUR_OR_A_KIND {
            @Override
            int map(int hand) {
                for (int i = HAND_SIZE; --i > 2; ) {
                    if (getCard(hand, i) == getCard(hand, i - 1) && getCard(hand, i) == getCard(hand, i - 2) && getCard(hand, i) == getCard(hand, i - 3)) {
                        return moveCard(moveCard(moveCard(moveCard(hand, C1, i), C2, i - 1), C3, i - 2), C4, i - 3);
                    }
                }
                return -1;
            }
        },
        STRAIGHT_FLUSH {
            @Override
            int map(int hand) {
                return isFlush(hand) ? STRAIGHT.map(clearFlush(hand)) : -1;
            }
        };

        abstract int map(int hand);
    }

    public static class HandScore implements Comparable<HandScore> {
        final int hand;
        final int map;
        final Ranking ranking;
        final Ranking[] RANKINGS = Ranking.values();

        public HandScore(int hand) {
            this.hand = hand;
            for (int i = RANKINGS.length; --i >= 0; ) {
                Ranking ranking = RANKINGS[i];
                int map = ranking.map(hand);
                if (map >= 0) {
                    this.map = map;
                    this.ranking = ranking;
                    return;
                }
            }
            throw new AssertionError("This cannot happen");
        }

        @Override
        public int compareTo(HandScore o) {
            int i = ranking.compareTo(o.ranking);
            if (i != 0) {
                return i;
            }
            return map - o.map;
        }

        @Override
        public String toString() {
            return "HandScore{" +
                    "hand=" + hand +
                    ", map=" + map +
                    ", ranking=" + ranking +
                    '}';
        }
    }

    public static int valueOf(String txt) {
        int[] ranks = new int[PokerHand.HAND_SIZE];
        int[] suits = new int[PokerHand.HAND_SIZE];

        try {
            String[] cards = txt.split(" ");
            for (int i = 0; i < PokerHand.HAND_SIZE; i++) {
                String card = cards[i];
                assert card.length() == 2;
                ranks[i] = PokerHand.R.indexOf(card.charAt(0));
                suits[i] = PokerHand.S.indexOf(card.charAt(1));
                assert ranks[i] >= 0 && suits[i] >= 0;
            }
            Arrays.sort(ranks);
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

        } catch (Exception e) {
            throw new AssertionError("");
        }
    }

    public static void main(String[] args) {
        String input = "AD JS QD JD TD";
        HandScore handScore = new HandScore(PokerHand.valueOf(input));
        System.out.println(handScore.ranking.toString().toLowerCase());
    }
}

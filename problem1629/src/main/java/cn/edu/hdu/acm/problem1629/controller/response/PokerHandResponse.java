package cn.edu.hdu.acm.problem1629.controller.response;

public class PokerHandResponse {
    private String originalInput;
    private String handPart;      // e.g., "TH JH QC QD QS"
    private String deckPart;      // e.g., "QH KH AH 2S 6S"
    private String bestHandType;  // e.g., "straight-flush"

    // 构造函数（用于生成输出字符串）
    public String getOutputLine() {
        return String.format("Hand: %s Deck: %s Best hand: %s",
                handPart, deckPart, bestHandType);
    }

    // Getters
    public String getOriginalInput() { return originalInput; }
    public String getHandPart() { return handPart; }
    public String getDeckPart() { return deckPart; }
    public String getBestHandType() { return bestHandType; }

    // Setters (or use builder)
    public static PokerHandResponse of(String input, String hand, String deck, String best) {
        PokerHandResponse res = new PokerHandResponse();
        res.originalInput = input;
        res.handPart = hand;
        res.deckPart = deck;
        res.bestHandType = best;
        return res;
    }
}

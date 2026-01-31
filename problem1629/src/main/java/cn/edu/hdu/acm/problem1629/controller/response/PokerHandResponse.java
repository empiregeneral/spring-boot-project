package cn.edu.hdu.acm.problem1629.controller.response;

import lombok.Data;
import lombok.Getter;

@Data
public class PokerHandResponse {
    @Getter
    private String originalInput;
    @Getter
    private String handPart;      // e.g., "TH JH QC QD QS"
    @Getter
    private String deckPart;      // e.g., "QH KH AH 2S 6S"
    @Getter
    private String bestHandType;  // e.g., "straight-flush"

    // 构造函数（用于生成输出字符串）
    public String getOutputLine() {
        return String.format("Hand: %s Deck: %s Best hand: %s",
                handPart, deckPart, bestHandType);
    }


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

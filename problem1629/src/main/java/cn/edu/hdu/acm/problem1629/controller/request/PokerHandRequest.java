package cn.edu.hdu.acm.problem1629.controller.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PokerHandRequest {
    // 正则解释：
    // - [2-9TJQKA]{1}[CDHS]{1} : 一张合法牌
    // - ( ... ){10}            : 恰好 10 张
    // - 中间用单个空格分隔
    private static final String CARD_REGEX = "[2-9TJQKA][CDHS]";
    private static final String INPUT_REGEX =
            "^" + CARD_REGEX + "( " + CARD_REGEX + "){9}$";

    @Pattern(regexp = INPUT_REGEX, message = "Invalid poker hand input. Expected 10 cards like 'TH JH QC QD QS QH KH AH 2S 6S'")
    @Size(min = 29, max = 29, message = "Input must be exactly 29 characters (10 cards with spaces)")
    private String inputLine;

    // Getter / Setter
    public String getInputLine() { return inputLine; }
    public void setInputLine(String inputLine) { this.inputLine = inputLine; }
}

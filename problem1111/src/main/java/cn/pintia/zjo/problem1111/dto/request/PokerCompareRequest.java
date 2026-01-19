package cn.pintia.zjo.problem1111.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PokerCompareRequest {
    @NotBlank(message = "Hand 1 is required")
    @Pattern(regexp = "([2-9TJQKA][HDCS]\\s*){4}[2-9TJQKA][HDCS]",
            message = "Invalid format. Use 5 cards like: '2H 3D 5S 9C KD'")
    private String hand1;

    @NotBlank(message = "Hand 2 is required")
    @Pattern(regexp = "([2-9TJQKA][HDCS]\\s*){4}[2-9TJQKA][HDCS]",
            message = "Invalid format. Use 5 cards like: '2H 3D 5S 9C KD'")
    private String hand2;

    public String getHand1() { return hand1; }
    public void setHand1(String hand1) { this.hand1 = hand1; }

    public String getHand2() { return hand2; }
    public void setHand2(String hand2) { this.hand2 = hand2; }
}

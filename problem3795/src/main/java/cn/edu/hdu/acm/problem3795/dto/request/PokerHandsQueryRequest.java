package cn.edu.hdu.acm.problem3795.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Data
public class PokerHandsQueryRequest {
    @NotBlank(message = "Hand is required")
    @Pattern(regexp = "([2-9TJQKA][HDCS]\\s*){4}[2-9TJQKA][HDCS]",
            message = "Invalid format. Use 5 cards like: '2H 3D 5S 9C KD'")
    private String hand;

    public String getHand() {
        return hand;
    }
}

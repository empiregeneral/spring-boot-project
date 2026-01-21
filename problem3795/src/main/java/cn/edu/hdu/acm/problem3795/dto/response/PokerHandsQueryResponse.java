package cn.edu.hdu.acm.problem3795.dto.response;

import lombok.Data;

@Data
public class PokerHandsQueryResponse {
    private String result;

    private int value;

    public PokerHandsQueryResponse(String result, int value) {
        this.result = result;
        this.value = value;
    }

}

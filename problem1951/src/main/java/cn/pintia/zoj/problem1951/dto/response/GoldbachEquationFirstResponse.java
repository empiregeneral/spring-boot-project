package cn.pintia.zoj.problem1951.dto.response;

import lombok.Data;

@Data
public class GoldbachEquationFirstResponse {
    private String result;
    private int status;

    public GoldbachEquationFirstResponse(String result, int status) {
        this.result = result;
        this.status = status;
    }
}

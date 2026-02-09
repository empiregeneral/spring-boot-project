package cn.pintia.zjo.problem1111.dto.response;

import cn.pintia.zjo.problem1111.enumeration.Judgement;

public class PokerCompareResponse {
    private final Judgement result;
    private final String reason;
    private final String winner; // "player1", "player2", "tie"

    public PokerCompareResponse(Judgement result, String reason, String winner) {
        this.result = result;
        this.reason = reason;
        this.winner = winner;
    }


    public Judgement getResult() { return result; }
    public String getReason() { return reason; }
    public String getWinner() { return winner; }

}

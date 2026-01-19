package cn.pintia.zjo.problem1111.dto.response;

public class PokerCompareResponse {
    private String result;
    private String reason;
    private String winner; // "player1", "player2", "tie"

    public PokerCompareResponse(String result, String reason, String winner) {
        this.result = result;
        this.reason = reason;
        this.winner = winner;
    }

    public String getResult() { return result; }
    public String getReason() { return reason; }
    public String getWinner() { return winner; }
}

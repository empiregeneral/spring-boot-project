package cn.pintia.zjo.problem1111.enumeration;

public enum Judgement {
    Player1Win("player1 wins."),
    Tie("Tie."),
    Player2Win("player2 wins."),
    ;
    private String description;

    Judgement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
